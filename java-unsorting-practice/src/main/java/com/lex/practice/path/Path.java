package com.lex.practice.path;

import java.io.File;

/**
 * @author : Lex Yu
 * @date : 2023/6/28
 */
public class Path {
	public static void main(String[] args) {
		String currentPath = System.getProperty("user.dir");
		System.out.println("Current Path: " + currentPath);

		File currentDir = new File("");
	}
}
