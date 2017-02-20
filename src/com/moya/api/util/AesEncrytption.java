package com.moya.api.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AesEncrytption {

	private static final String ALGO = "AES";

	private byte[] keyValue;

	public AesEncrytption(String saltValue) {
		keyValue = saltValue.getBytes();
	}

	public String encrypt(String Data) throws Exception{
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	public String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * String password = "1234567890098765432112345678900987654321"; String
	 * passwordEnc = AesEncrytption.encrypt(password); String passwordDec =
	 * AesEncrytption.decrypt(passwordEnc);
	 * 
	 * System.out.println("Plain Text : " + password); System.out.println(
	 * "Encrypted Text : " + passwordEnc+" passwordEnc Length :"
	 * +passwordEnc.length()); System.out.println("Decrypted Text : " +
	 * passwordDec); }
	 */
}