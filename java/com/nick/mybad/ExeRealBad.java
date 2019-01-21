package com.nick.mybad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * a bad implementation to verify scan tools. bad thing: cmd injection,
 * termination by code
 * 
 */
public class ExeRealBad {
	public static String checkDir(Runtime r, String dir) throws IOException, InterruptedException {

		if (dir == null || dir.indexOf("\\") != -1)
			System.exit(1);

		Process p = r.exec(new String[] { "cmd.exe", "/c", dir });
		Thread.sleep(1000);
		InputStream iStm = p.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0;
		byte[] buff = new byte[64];
		while ((len = iStm.read(buff)) != -1) {
			baos.write(buff, 0, len);
		}
		p.destroy();

		return new String(baos.toByteArray());
	}
}
