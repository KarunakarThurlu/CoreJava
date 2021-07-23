package com.app.chriptography;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;



public class AES_ECB_Demo {
	public KeyGenerator keygenerator;
	public SecretKey myKey;
	Cipher ecipher;
	Cipher dcipher;
	AES_ECB_Demo() throws NoSuchAlgorithmException, NoSuchPaddingException{
		keygenerator=KeyGenerator.getInstance("AES");
		myKey=	keygenerator.generateKey();
		ecipher=Cipher.getInstance("AES");
		dcipher=Cipher.getInstance("AES");
	}

	public byte[] encrypt(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		ecipher.init(Cipher.ENCRYPT_MODE, myKey);
		byte[] text=str.getBytes();
		byte[] en_text=ecipher.doFinal(text);
		return en_text;
	}
	public String decrypt(byte[] es) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		dcipher.init(Cipher.DECRYPT_MODE, myKey);
		byte[] de_str=dcipher.doFinal(es);
		return new String(de_str);
	}
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String s="Karunakar";
		System.out.println("Raw String :"+s);
		AES_ECB_Demo aes=new AES_ECB_Demo();
		byte[] es=aes.encrypt(s);
		System.out.println("Decrypt String :"+es);
		String ds=aes.decrypt(es);
		System.out.println("Encrypt String :"+ds);
		
	}
}
