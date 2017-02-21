package com.tictactoe.api.util;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

public class CacheUtility {

	private static JCS cache = null;

	public static JCS getCache() throws CacheException {
		if (cache == null)
			cache = JCS.getInstance("userCache");
		return cache;
	}

}
