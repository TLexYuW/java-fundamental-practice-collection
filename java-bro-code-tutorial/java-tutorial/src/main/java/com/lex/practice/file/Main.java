package com.lex.practice.file;

import java.io.File;

/**
 * @author : Lex Yu
 * @date : 2023/6/16
 */
public class Main {
	public static void main(String[] args) {
		// file
		// An abstract representation of file and directory pathnames
		File file = new File("java-bro-code-tutorial/java-tutorial/result.json");
		if (file.exists()) {
			System.out.println("File exists.");
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.isFile());
			file.delete();
		} else {
			System.out.println("File not exists.");
		}
	}
}
