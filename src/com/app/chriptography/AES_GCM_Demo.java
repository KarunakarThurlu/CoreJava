package com.app.chriptography;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;



public class AES_GCM_Demo {

	 /*
      Using default IV, SALT values like

      private static byte[] IV = new byte[12];
      private static byte[] SALT_ES_DS = new byte[16];

      then corresponding SALT,IV  default values be like

      SALT :[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
      IV   :[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

      Note:- this SALT and IV Remains same for all Passwords

     */

	private static final String ALGORITHAM ="AES";
	private static final String AES_ALGORITHAM_MODE ="AES/GCM/NoPadding";
	private static final int AES_KEY_SIZE = 256;
	private static final int GCM_IV_LENGTH = 12;
	private static final int GCM_TAG_LENGTH = 16;
	private static final int SALT_LENGTH_BYTE = 16;
	private static  final int ITERATION_COUNT = 65536;
	private static byte[] IV = new byte[GCM_IV_LENGTH];
	private static byte[] SALT = new byte[SALT_LENGTH_BYTE];
	private static final Charset UTF_8 = StandardCharsets.UTF_8;

	private SecretKey secretKey;
	private Cipher ecipher;
	private Cipher dcipher;

	public AES_GCM_Demo(String key)  {
		try {
			this.secretKey=generateKey(key.toCharArray());
			this.ecipher=Cipher.getInstance(AES_ALGORITHAM_MODE);
			this.dcipher=Cipher.getInstance(AES_ALGORITHAM_MODE);
			this.ecipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV));
			this.dcipher.init(Cipher.DECRYPT_MODE,secretKey, new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch(NoSuchPaddingException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static SecretKey generateKey(char[] password) throws  Exception {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(password, SALT, ITERATION_COUNT, AES_KEY_SIZE);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHAM);
		return secret;
	}
	public String doEncrypt(String rawString) {
		try {
			byte[] cipherText= ecipher.doFinal(rawString.getBytes());
			return Base64.getEncoder().encodeToString(cipherText);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String doDecrypt(String decryptedString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException  {
		byte[] decode = Base64.getDecoder().decode(decryptedString.getBytes(UTF_8));
		byte[] decryptedText = dcipher.doFinal(decode);
		return new String(decryptedText, UTF_8);
	}

	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		AES_GCM_Demo aes=new AES_GCM_Demo("cH@nGEme!FuC@N");
		String plainText = "47A881O9w6";
		System.out.println("Original Text : " + plainText);
		String cipherText = aes.doEncrypt(plainText);
		System.out.println(cipherText.length());
		System.out.println("Encrypted Text : " + cipherText);
		String decryptedText = aes.doDecrypt(cipherText);
		System.out.println("DeCrypted Text : " + decryptedText);
		System.out.println("SALT :"+Arrays.toString(SALT));
		System.out.println("IV   :"+Arrays.toString(IV));
	}
}
