package com.kechun.util;

import org.apache.shiro.crypto.hash.Md5Hash;


public class Md5Util {
	public static String getMD5(String msg, String salt) {
		return new Md5Hash(msg, salt, 4).toString();
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = getMD5("12345", "0009jl");
		System.out.println(str);
	}
}
