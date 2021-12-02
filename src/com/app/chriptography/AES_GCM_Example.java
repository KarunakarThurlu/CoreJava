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
    private static String salt_Vale= "qerh234";
    private static final String AES_ALGORITHAM_MODE ="AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 256;
    private static final int GCM_TAG_LENGTH = 16;
    private static  final int ITERATION_COUNT = 1024;
    private static byte[] IV = "Ch@NgECh@NgE".getBytes();
    private static byte[] SALT_ES_DS="W2#$34RTy67J@r78LQ".getBytes();
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    private SecretKey secretKey;
    private Cipher ecipher;
    private Cipher dcipher;
    public  AES_GCM_Example(String key) throws Exception{
        this.secretKey=generateKey(key.toCharArray(),getSalt(key));
        this.ecipher=Cipher.getInstance(AES_ALGORITHAM_MODE);
        this.dcipher=Cipher.getInstance(AES_ALGORITHAM_MODE);
        this.ecipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV));
        this.dcipher.init(Cipher.DECRYPT_MODE,secretKey, new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV));
    }
    public static SecretKey generateKey(char[] password,byte[] SALT) throws  Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, SALT_ES_DS, ITERATION_COUNT, AES_KEY_SIZE);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHAM);
        return secret;
    }


    public byte[] getSalt(String passPase){
        if(passPase.length()==16){
            char ch[]=passPase.toCharArray();
            Arrays.sort(ch);
            String salt=new String(ch);
            System.out.println(salt);
            return salt.getBytes();
        }else{
            char c[]=passPase.toCharArray();
            Arrays.sort(c);
            String salt= new String(c);
            while(salt.length()<17)
                salt = salt + passPase;
            System.out.println(salt +" "+salt.length());
            System.out.println("salt length : "+salt.substring(0,16)+" : "+salt.substring(0,16).length());
            return salt.substring(0,16).getBytes();
        }
    }//mf6/6VGr2eaQKspj2KGWWslaegphr/IRIaU=
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
        AES_GCM_Example e=new AES_GCM_Example("Ch@0gXZU$NPE");
//        String pText = "4782A4b7C0";
//        System.out.println("Plain Text : "+pText);
//        String encryptedTextBase64 = e.encrypt(pText);
//        System.out.println("EncryptedTextBase64 : "+encryptedTextBase64);
//        System.out.println("EncryptedTextBase64 length : " +encryptedTextBase64.length());
        String decreptedTextBase64 = e.decrypt("vOMD/CxAP6IEEhgrZUzgi5xh9K1WfQ6K5is=");
        System.out.println("DecryptedTextBase64 : "+decreptedTextBase64);
//        System.out.println("SALT VALUE  : "+Arrays.toString(SALT_ES_DS));
//        System.out.println("IV VALUE    : "+Arrays.toString(IV));

    }
}


