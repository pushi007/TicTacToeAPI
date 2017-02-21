package com.tictactoe.api.util;

import java.io.UnsupportedEncodingException;

public class MultilingualUtility {

	public String toUnicode(String nativeLanguage) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < nativeLanguage.length(); i++) {
			char ch = nativeLanguage.charAt(i);
			if ((ch >= 0x0020) && (ch <= 0x007e)) {
				stringBuffer.append(ch);
			} else {
				stringBuffer.append("\\u");
				String hex = Integer.toHexString(nativeLanguage.charAt(i) & 0xFFFF);
				for (int j = 0; j < 4 - hex.length(); j++) {
					stringBuffer.append("0");
				}
				stringBuffer.append(hex.toLowerCase());
			}
		}
		return (new String(stringBuffer));
	}

	public String fromUnicode(String unicode) {
		byte[] b = unicode.getBytes();
		String actualCharacter = null;
		try {
			actualCharacter = new String(b, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return actualCharacter;
	}
}
