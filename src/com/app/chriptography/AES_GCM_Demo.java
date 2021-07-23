package com.app.chriptography;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;



public class AES_GCM_Demo {
 

	private static final int AES_KEY_SIZE = 256;
	private static final int GCM_IV_LENGTH = 12;
	private static final int GCM_TAG_LENGTH = 16;
	private byte[] IV = new byte[GCM_IV_LENGTH];

	private KeyGenerator keyGenerator;
	private SecretKey secretKey;
	private Cipher ecipher;
	private Cipher dcipher;

	public AES_GCM_Demo()  {
		try {
			keyGenerator=KeyGenerator.getInstance("AES");
			keyGenerator.init(AES_KEY_SIZE);
			secretKey=keyGenerator.generateKey();
			new SecureRandom().nextBytes(IV);
			ecipher=Cipher.getInstance("AES/GCM/NoPadding");
			dcipher=Cipher.getInstance("AES/GCM/NoPadding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch(NoSuchPaddingException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public byte[] doEncrypt(String rawString) {
		SecretKeySpec keySpec=new SecretKeySpec(secretKey.getEncoded(), "AES");
		GCMParameterSpec gcmParameterSpec =new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);
		try {
			ecipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
			byte[] cipherText= ecipher.doFinal(rawString.getBytes());
			return cipherText;
		}catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String doDecrypt(byte[] decryptedString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException  {
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
		GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);
		dcipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
		byte[] decryptedText = dcipher.doFinal(decryptedString);
		return new String(decryptedText);
	}

	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		AES_GCM_Demo aes=new AES_GCM_Demo();
		String plainText = "Karunakar Thurlu";
		System.out.println("Original Text : " + plainText);
		byte[] cipherText = aes.doEncrypt(plainText);
		System.out.println("Encrypted Text : " + Base64.getEncoder().encodeToString(cipherText));

		String decryptedText = aes.doDecrypt(cipherText);
		System.out.println("DeCrypted Text : " + decryptedText);
	}
}
