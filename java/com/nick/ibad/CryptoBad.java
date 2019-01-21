package com.nick.ibad;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;

/**
 * a bad crypto implementation to verify scan tools. bad things: hardcoded key,
 * weak algorithm, weak mode, dump sensitive info
 * 
 */
public class CryptoBad {
	private static byte[] deskey = "12345678".getBytes();

	public static byte[] getMac(String userId, String authKey, String ts) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		System.out.println("getMac for userId=" + userId + ", authKey=" + authKey + ", ts=" + ts);

		byte[] mac = encrypt((userId + authKey + ts).getBytes());

		System.out.println("result: " + new String(mac));
		return mac;
	}

	public static byte[] encrypt(byte[] plain) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cp = Cipher.getInstance("DES/ECB/PKCS5Padding");
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		Key k = skf.generateSecret(new SecretKeySpec(deskey, "DES"));
		cp.init(Cipher.ENCRYPT_MODE, k);
		return cp.doFinal(plain);
	}

	public static byte[] decrypt(byte[] cipher) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		Cipher cp = Cipher.getInstance("DES/ECB/PKCS5Padding");
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		Key k = skf.generateSecret(new SecretKeySpec(deskey, "DES"));
		cp.init(Cipher.DECRYPT_MODE, k);
		return cp.doFinal(cipher);
	}
}
