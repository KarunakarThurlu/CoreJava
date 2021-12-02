package com.app.chriptography;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class AES_ECB_Demo {

	Cipher ecipher;
	Cipher dcipher;

	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	AES_ECB_Demo(String foo) throws NoSuchAlgorithmException,Exception{
		Key myKey=	generayeKey(foo);
		ecipher=Cipher.getInstance("AES");
		dcipher=Cipher.getInstance("AES");
		ecipher.init(Cipher.ENCRYPT_MODE,myKey);
		dcipher.init(Cipher.DECRYPT_MODE,myKey);
	}

	private static Key generayeKey(String passphase){
		byte[] keyvalue=passphase.getBytes();
		Key key=new SecretKeySpec(keyvalue,"AES");
		return key;
	}
	public String encrypt(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] utf8=str.getBytes(UTF_8);
		byte[] cipherText= ecipher.doFinal(utf8);
		return Base64.getEncoder().encodeToString(cipherText);
	}
	public String decrypt(String es) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] decode = Base64.getDecoder().decode(es.getBytes(UTF_8));
		byte[] plainText = dcipher.doFinal(decode);
		return new String(plainText, UTF_8);
	}
	public static void main(String[] args) throws Exception {
		String s="Karunakar";
		System.out.println("Raw String :"+s);
		AES_ECB_Demo aes=new AES_ECB_Demo("fooooo00000000000000000000000000000");
		String es=aes.encrypt(s);
		System.out.println("Decrypt String :"+es);
		String ds=aes.decrypt(es);
		System.out.println("Encrypt String :"+ds);
		//x1r453uszgb+8ZUVvqyHLw==
	}
}
