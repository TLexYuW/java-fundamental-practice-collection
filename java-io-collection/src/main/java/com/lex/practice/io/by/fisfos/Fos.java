package com.lex.practice.io.by.fisfos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Fos {
	public static void main(String[] args) {
		try (FileOutputStream fis = new FileOutputStream("fosOutput.txt")) {
			byte[] array = "This is fis Output".getBytes();
			fis.write(array);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
