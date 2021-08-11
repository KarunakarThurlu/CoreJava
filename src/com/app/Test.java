package com.app;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Test {

	private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";

	private static final int TAG_LENGTH_BIT = 128; // must be one of {128, 120,     112, 104, 96}
	private static final int IV_LENGTH_BYTE = 12;
	private static final int SALT_LENGTH_BYTE = 16;
	public static final int ITERATION_COUNT = 1000;
	public static final int KEY_LENGTH = 256;

	private static final Charset UTF_8 = StandardCharsets.UTF_8;

	// return a base64 encoded AES encrypted text
	public static String encrypt(byte[] salt, byte[] pText, String password) throws Exception {
		// GCM recommended 12 bytes iv?
		byte[] iv = getRandomNonce(IV_LENGTH_BYTE);

		// secret key from password
		SecretKey aesKeyFromPassword = getAESKeyFromPassword(password.toCharArray(), salt);

		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

		// ASE-GCM needs GCMParameterSpec
		cipher.init(Cipher.ENCRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

		byte[] cipherText = cipher.doFinal(pText);

		// prefix IV and Salt to cipher text
		byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
				.put(iv)
				.put(salt)
				.put(cipherText)
				.array();

		// string representation, base64, send this string to other for decryption.
		return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);

	}

	// we need the same password, salt and iv to decrypt it
	private static String decrypt(String cText, String password) throws Exception {
		byte[] decode = Base64.getDecoder().decode(cText.getBytes(UTF_8));

		// get back the iv and salt from the cipher text
		ByteBuffer bb = ByteBuffer.wrap(decode);

		byte[] iv = new byte[IV_LENGTH_BYTE];
		bb.get(iv);

		byte[] salt = new byte[SALT_LENGTH_BYTE];
		bb.get(salt);

		byte[] cipherText = new byte[bb.remaining()];
		bb.get(cipherText);

		// get back the aes key from the same password and salt
		SecretKey aesKeyFromPassword = getAESKeyFromPassword(password.toCharArray(), salt);

		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

		cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

		byte[] plainText = cipher.doFinal(cipherText);

		return new String(plainText, UTF_8);

	}


	public static byte hexToByte(String hexString) {
		int firstDigit = toDigit(hexString.charAt(0));
		int secondDigit = toDigit(hexString.charAt(1));
		return (byte) ((firstDigit << 4) + secondDigit);
	}

	public static byte[] decodeHexString(String hexString) {
		if (hexString.length() % 2 == 1) {
			throw new IllegalArgumentException(
					"Invalid hexadecimal String supplied.");
		}

		byte[] bytes = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i += 2) {
			bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
		}
		return bytes;
	}

	private static int toDigit(char hexChar) {
		int digit = Character.digit(hexChar, 16);
		if (digit == -1) {
			throw new IllegalArgumentException(
					"Invalid Hexadecimal Character: "+ hexChar);
		}
		return digit;
	}

	// Random byte[] with length numBytes
	public static byte[] getRandomNonce(int numBytes) {
		byte[] nonce = new byte[numBytes];
		new SecureRandom().nextBytes(nonce);
		return nonce;
	}

	// Password derived AES 256 bits secret key
	public static SecretKey getAESKeyFromPassword(char[] password, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		SecretKeyFactory factory =    SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		// iterationCount = 1000
		// keyLength = 256
		KeySpec spec = new PBEKeySpec(password, salt, ITERATION_COUNT,
				KEY_LENGTH);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

		String encodedKey = hex(secret.getEncoded());

		// print SecretKey as hex
		System.out.println("SecretKey: " + encodedKey);

		return secret;

	}

	// hex representation
	public static String hex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append(String.format("%02x", b));
		}
		return result.toString();
	}



	public static void main(String[] args) throws Exception {
		String OUTPUT_FORMAT = "%-30s:%s";
		String PASSWORD = "D!Gt@lBu#!";

		// plain text
		String pText = "4782";

		// convert hex string to byte[]
		byte[] salt = decodeHexString("A009C1A485912C6AE630D3E744240B04");

		String encryptedTextBase64 = Test.encrypt(salt, pText.getBytes(UTF_8), PASSWORD);

		System.out.println("\n------ AES GCM Password-based Encryption ------");
		System.out.println(String.format(OUTPUT_FORMAT, "Input (plain text)", pText));
		System.out.println(String.format(OUTPUT_FORMAT, "Encrypted (base64) ", encryptedTextBase64));

		System.out.println("\n------ AES GCM Password-based Decryption ------");
		System.out.println(String.format(OUTPUT_FORMAT, "Input (base64)", encryptedTextBase64));

		String decryptedText = Test.decrypt(encryptedTextBase64, PASSWORD);
		System.out.println(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText));
	}
}
