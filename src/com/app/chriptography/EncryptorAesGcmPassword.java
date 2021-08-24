package com.app.chriptography;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * AES-GCM inputs - 12 bytes IV, need the same IV and secret keys for encryption and decryption.
 * <p>
 * The output consist of iv, password's salt, encrypted content and auth tag in the following format:
 * output = byte[] {i i i s s s c c c c c c ...}
 * <p>
 * i = IV bytes
 * s = Salt bytes
 * c = content bytes (encrypted content)
 */
public class EncryptorAesGcmPassword {

     /*
      Using Dynamic IV, SALT values like

      private static byte[] IV = new SecureRandom().nextBytes(12);
      private static byte[] SALT_ES_DS = new SecureRandom().nextBytes(16);

      then corresponding SALT,IV values be we can't guess it will be random values like following


      SALT VALUE  : [8, 22, -13, -96, 111, -106, -86, 75, -70, 85, -29, 68, -40, -58, -56, 19]
      IV VALUE    : [-105, 116, -22, -124, 34, -8, -52, 58, -4, 64, -101, 16]

      SALT VALUE  : [-70, 77, -56, -128, -14, 80, 114, -10, -19, 90, -126, -86, -83, 38, 50, -117]
      IV VALUE    : [-27, -13, 27, 69, -41, 31, -120, -96, 15, -80, -100, 38]

      Note:- this SALT and IV Different for each password

     */

    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";

    private static final int TAG_LENGTH_BIT = 128; // must be one of {128, 120, 112, 104, 96}
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    // return a base64 encoded AES encrypted text
    public static String encrypt(byte[] pText, String password) throws Exception {

        // 16 bytes salt
        byte[] salt = EncryptorAesGcmPassword.getRandomNonce(SALT_LENGTH_BYTE);

        System.out.println("SALT VALUE  : "+ Arrays.toString(salt));
        // GCM recommended 12 bytes iv?
        byte[] iv = EncryptorAesGcmPassword.getRandomNonce(IV_LENGTH_BYTE);
        System.out.println("SALT VALUE  : "+ Arrays.toString(iv));

        // secret key from password
        SecretKey aesKeyFromPassword = EncryptorAesGcmPassword.getAESKeyFromPassword(password.toCharArray(), salt);

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
        SecretKey aesKeyFromPassword = EncryptorAesGcmPassword.getAESKeyFromPassword(password.toCharArray(), salt);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        byte[] plainText = cipher.doFinal(cipherText);

        return new String(plainText, UTF_8);

    }

    public static void main(String[] args) throws Exception {
        String PASSWORD = "this is a password";
        String pText = "4782A4b7C0";
        String encryptedTextBase64 = EncryptorAesGcmPassword.encrypt(pText.getBytes(UTF_8), PASSWORD);
        System.out.println( "Input (plain text) :"+ pText);
        System.out.println( "Encrypted (base64) :"+ encryptedTextBase64);
        System.out.println( "Input (base64)     :"+ encryptedTextBase64);
        System.out.println( "Encrypted (base64) length :"+encryptedTextBase64.length());
        String decryptedText = EncryptorAesGcmPassword.decrypt(encryptedTextBase64, PASSWORD);
        System.out.println("Decrypted (plain text) :"+ decryptedText);

    }
    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }
    public static SecretKey getAESKeyFromPassword(char[] password, byte[] salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        return secret;
    }

}
