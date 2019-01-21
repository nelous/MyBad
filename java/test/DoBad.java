package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.nick.mybad.CryptoBad;
import com.nick.mybad.ExeRealBad;

public class DoBad {

	public static void main(String[] args) throws Throwable {
//		byte[] plain = "i am plain.".getBytes();
//		byte[] cipher = CryptoBad.encrypt(plain);
//		System.out.println(cipher.length);
//		byte[] dec = CryptoBad.decrypt(cipher);
//
//		System.out.println(new String(dec));

		String res = ExeRealBad.checkDir(Runtime.getRuntime(), "d:\\");
		System.out.println(res);
		
	}

}
