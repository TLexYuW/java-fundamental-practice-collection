package com.lex.practice.file.writer;

import java.io.FileWriter;
import java.util.Arrays;

/**
 * @author : Lex Yu
 * @date : 2023/6/16
 */
public class Main {
	public static void main(String[] args) {
		try (FileWriter writer =
				     new FileWriter("java-bro-code-tutorial/java-tutorial/poem.txt")) {
			writer.write("""
					Roses are red
					Violets are blue
					Booty booty booty booty
					Rockin' everywhere!
					""");
			writer.append("(A poem by Bro)");
		} catch (Exception ex) {
			System.out.println(Arrays.toString(ex.getStackTrace()));
		}

	}
}
