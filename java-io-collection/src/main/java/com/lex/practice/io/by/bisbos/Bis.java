package com.lex.practice.io.by.bisbos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Bis {
	public static void main(String[] args) {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bosOutput.txt"))) {
			String result = new String(bis.readAllBytes());
			System.out.println(result);
		} catch (Exception ex) {
			System.out.println("err");
		}
	}
}
