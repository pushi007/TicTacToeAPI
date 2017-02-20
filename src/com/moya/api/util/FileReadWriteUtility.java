package com.moya.api.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteUtility {

	public static boolean writeFile(String pathname, byte[] fileData) throws IOException {

		File file = new File(pathname);

		if (file.exists()) {
			return false;
		}
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(pathname);
		fos.write(fileData);
		fos.flush();
		fos.close();
		return true;
	}
	
public static boolean writeThumb(String pathname, byte[] fileData) throws IOException {
		
		File file = new File(pathname);
		
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(pathname);
		fos.write(fileData);
		fos.flush();
		fos.close();
		return true;
	}

	public static void deleteFile(String path1) {
		File file = new File(path1);
		if (file.delete()) {
			System.out.println(file.getName() + " is deleted!");
		} else {
			System.out.println("Delete operation is failed.");
		}

	}

}
