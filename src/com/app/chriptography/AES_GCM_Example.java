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
import java.util.Base64;

public class AES_GCM_Example {

    private static final String ALGORITHAM ="AES";
    private static final String AES_ALGORITHAM_MODE ="AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 256;
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;
    private static final int SALT_LENGTH_BYTE = 16;
    private static  final int ITERATION_COUNT = 65536;
    private byte[] IV = new byte[GCM_IV_LENGTH];
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    private SecretKey secretKey;
    private static byte[] SALT_ES_DS;
    private Cipher ecipher;
    private Cipher dcipher;
   public  AES_GCM_Example(String key) throws Exception{
       this.SALT_ES_DS= decodeHexString("A009C1A485912C6AE630D3E744240B04");
       this.secretKey=generateKey(key.toCharArray());
       this.ecipher=Cipher.getInstance(AES_ALGORITHAM_MODE);
       this.dcipher=Cipher.getInstance(AES_ALGORITHAM_MODE);
       this.ecipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV));
       this.dcipher.init(Cipher.DECRYPT_MODE,secretKey, new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV));
    }
    public static SecretKey generateKey(char[] password) throws  Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, SALT_ES_DS, ITERATION_COUNT, AES_KEY_SIZE);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHAM);
        System.out.println(secret.toString());
        return secret;
    }
    public  String encrypt(String pText) throws Exception {
        byte[] iv = getRandomNonce(GCM_IV_LENGTH);
        byte[] cipherText= ecipher.doFinal(pText.getBytes());
        byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + SALT_ES_DS.length + cipherText.length)
                .put(iv)
                .put(SALT_ES_DS)
                .put(cipherText)
                .array();
        return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);
    }
    private  String decrypt(String cText) throws Exception {
        byte[] decode = Base64.getDecoder().decode(cText.getBytes(UTF_8));
        ByteBuffer bb = ByteBuffer.wrap(decode);
        byte[] iv = new byte[GCM_IV_LENGTH];
        bb.get(iv);
        bb.get(SALT_ES_DS);
        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);
        byte[] plainText = dcipher.doFinal(cipherText);
        return new String(plainText, UTF_8);
    }


    public static byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    public static byte[] decodeHexString(String hexString) {
        if (hexString.length() % 2 == 1) {
            throw new IllegalArgumentException("Invalid hexadecimal String supplied.");
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
            throw new IllegalArgumentException("Invalid Hexadecimal Character: "+ hexChar);
        }
        return digit;
    }

    // Random byte[] with length numBytes
    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
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
        AES_GCM_Example e=new AES_GCM_Example("D!GiT@LBuY$123");
        String pText = "4782";
        String encryptedTextBase64 = e.encrypt(pText);
        System.out.println(encryptedTextBase64);
        System.out.println(encryptedTextBase64.length());
        String decreptedTextBase64 = e.decrypt(encryptedTextBase64);
        System.out.println(decreptedTextBase64);

    }
}


