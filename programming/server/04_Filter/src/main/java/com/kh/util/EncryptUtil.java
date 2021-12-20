package com.kh.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtil {
	/*
	 * 암호화의 방향성
	 * 	1) 단방향 : 암호화된 평문은 다시 복호화 할 수 없는 암호화 방식이다. (SHA2, MD5)
	 * 	2) 양방향 : 암호화된 평문을 다시 복호화 할 수 있는 암호화 방식이다. 
	 * 		2-1) 대칭키 : 암/복호화에 사용하는 키가 동일하다. (AES, DES)
	 * 		2-2) 비 대칭키 : 암/복화에 사용하는 키가 다르다. (RSA)
	 * 
	 * 
	 *	SHA2(Secure Hash Algorithm 2)
	 *	  1) SHA-256
	 *		- SHA-256은 임의 길이 메시지를 256비트(32바이트)의 축약된 메시지로 만들어내는 해시 알고리즘이다.
	 *	  2) SHA-512
	 *		- SHA-512는 임의 길이 메시지를 512비트(64바이트)의 축약된 메시지로 만들어내는 해시 알고리즘이다.
	 *	  * 암호화 해시 함수와 
	 */
	
	// 단방향 암호화(MD2, MD5, SHA-1, SHA-256, SHA-512)
	public static String onewWayEnc(String message, String algorithm) {
		byte[] digest;
		String encMessage = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			
			md.update(message.getBytes(Charset.forName(("UTF-8"))));
			
			digest = md.digest();
			
			encMessage = Base64.getEncoder().encodeToString(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encMessage;
	}
}
