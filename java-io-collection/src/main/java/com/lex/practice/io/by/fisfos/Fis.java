package com.lex.practice.io.by.fisfos;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Fis {
	public static void main(String[] args) {
		try (InputStream fis = new FileInputStream("fosOutput.txt")) {
			System.out.println("Number of remaining bytes: " + fis.available());
			long skip = fis.skip(2);
			int content;
			System.out.println("The actual number of bytes skipped: " + skip);
			System.out.println("The content read from file: ");
			while ((content=fis.read()) != -1) {
				System.out.print((char)content); // 中文亂碼 -> FileReader
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
