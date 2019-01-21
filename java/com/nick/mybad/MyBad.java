package com.nick.mybad;

public class MyBad {

	public static void main(String[] args) throws Throwable {
		if (args == null || args.length < 2)
			return;

		if ("e".equals(args[0])) {
			System.out.println(new String(CryptoBad.encrypt(args[1].getBytes())));
		} else if ("d".equals(args[0])) {
			System.out.println(new String(CryptoBad.decrypt(args[1].getBytes())));
		} else if ("g".equals(args[0])) {
			byte[] mac = CryptoBad.getMac(args[1], args[2], args[3]);
			System.out.println(new String(mac));
		} else if ("k".equals(args[0])) {
			byte[] k = CryptoBadEx.getKeyValue(64, args[1]);
			System.out.println(new String(k));
		} else if ("h".equals(args[0])) {
			byte[] hashed = CryptoBadEx.shaIt(args[1].getBytes());
			System.out.println(new String(hashed));
		} else if ("c".equals(args[0])) {
			ExeRealBad.checkDir(Runtime.getRuntime(), args[1]);
		} else {
			System.out.println("none");
		}
	}

}
