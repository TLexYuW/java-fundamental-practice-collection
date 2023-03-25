package com.lex.practice.by.bisbos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Bos {
	public static void main(String[] args) {
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bosOutput.txt"))) {
			byte[] array = "This is Bos Output".getBytes();
			bos.write(array);
		} catch (Exception ex) {
			System.out.println("err");
		}
	}
}
