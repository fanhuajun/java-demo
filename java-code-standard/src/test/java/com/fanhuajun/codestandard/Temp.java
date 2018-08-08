package com.fanhuajun.codestandard;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Temp {
	
	
	public static void main(String[] args) {
		 /*确定计算方法*/
		String text = "420124197811115933";
        MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			/*加密后的散列码字符串*/
			Encoder encoder = Base64.getEncoder();
			String strMd5=encoder.encodeToString(md5.digest(text.getBytes("utf-8")));
			System.out.println(strMd5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static byte[] md5(String value) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.reset();
        byte[] bytes = null;
        try {
            bytes = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.update(bytes);
        return md5.digest();
    }

}
