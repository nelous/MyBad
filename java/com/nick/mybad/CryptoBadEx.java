package com.nick.mybad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * a bad crypto implementation to verify scan tools. bad thing: use SecureRandom
 * with hardcoded condition, weak hash, no salt in hash
 * 
 */
public class CryptoBadEx {
	public static byte[] getKeyValue(int keyByteLen) {
		byte[] rtn = new byte[keyByteLen];
		new SecureRandom((System.currentTimeMillis() + "").getBytes()).nextBytes(rtn);
		return rtn;
	}

	public static byte[] getKeyValue(int keyByteLen, String alphabet) {
		byte[] rtn = new byte[keyByteLen];
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < keyByteLen; i++) {
			rtn[i] = (byte) alphabet.charAt(r.nextInt(alphabet.length()));
		}

		return null;
	}

	public static byte[] shaIt(byte[] seed) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		byte[] rtn = md.digest(seed);
		return rtn;
	}
}
