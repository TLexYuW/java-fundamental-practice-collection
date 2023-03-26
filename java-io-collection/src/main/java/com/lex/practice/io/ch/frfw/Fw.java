package com.lex.practice.io.ch.frfw;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Fw {
	public static void main(String[] args) {
		try (Writer writer = new FileWriter("fwOutput.txt")) {
			writer.write("This is fw Output");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
