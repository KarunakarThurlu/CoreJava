package com.app.chriptography;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AES_GCM_Example {
    /*
      Using Static IV, SALT values like

      private static byte[] IV = "Ch@NgE".getBytes();
      private static byte[] SALT_ES_DS = "W2#$34RTy67J@r78LQ".getBytes();

      then corresponding SALT,IV static values be like

      SALT VALUE  : [87, 50, 35, 36, 51, 52, 82, 84, 121, 54, 55, 74, 64, 114, 55, 56, 76, 81]
      IV VALUE    : [67, 104, 64, 78, 103, 69]

      Note:- this SALT and IV Remains same for all Passwords

     */
    private static final String ALGORITHAM ="AES";
    private static final String AES_ALGORITHAM_MODE ="AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 256;
    private static final int GCM_TAG_LENGTH = 16;
    private static  final int ITERATION_COUNT = 65536;
    private static byte[] IV = "Ch@NgE".getBytes();
    private static byte[] SALT_ES_DS="W2#$34RTy67J@r78LQ".getBytes();
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    private SecretKey secretKey;
    private Cipher ecipher;
    private Cipher dcipher;
   public  AES_GCM_Example(String key) throws Exception{
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
        return secret;
    }
    public  String encrypt(String pText) throws Exception {
        byte[] cipherText= ecipher.doFinal(pText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }
    private  String decrypt(String cText) throws Exception {
        byte[] decode = Base64.getDecoder().decode(cText.getBytes(UTF_8));
        byte[] plainText = dcipher.doFinal(decode);
        return new String(plainText, UTF_8);
    }

    public static void main(String[] args) throws Exception {
        AES_GCM_Example e=new AES_GCM_Example("D!GiT@LBuY$123");
        String pText = "4782A4b7C0";
        System.out.println("Plain Text : "+pText);
        String encryptedTextBase64 = e.encrypt(pText);
        System.out.println("EncryptedTextBase64 : "+encryptedTextBase64);
        System.out.println("EncryptedTextBase64 length : " +encryptedTextBase64.length());
        String decreptedTextBase64 = e.decrypt(encryptedTextBase64);
        System.out.println("DecryptedTextBase64 : "+decreptedTextBase64);
        System.out.println("SALT VALUE  : "+Arrays.toString(SALT_ES_DS));
        System.out.println("IV VALUE    : "+Arrays.toString(IV));

    }
}


