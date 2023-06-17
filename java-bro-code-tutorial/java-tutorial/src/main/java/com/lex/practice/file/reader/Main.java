package com.lex.practice.file.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * @author : Lex Yu
 * @date : 2023/6/16
 */
public class Main {
	public static void main(String[] args) {
		// FileReader
		// read the contents of a file as a stream of characters.
		// One by one read() returns an int value which contains the byte value
		// when read() returns -1, there is no more data to be read
		try (FileReader reader =
				     new FileReader("java-bro-code-tutorial/java-tutorial/art.txt")) {
			int data = reader.read();
			while (data != -1){
				System.out.print((char)data);
				data = reader.read();
			}
		} catch (Exception ex) {
			System.out.println(Arrays.toString(ex.getStackTrace()));
		}

	}
}
