package com.lex.practice.io.ch.frfw;

import java.io.FileReader;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Fr {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("input.txt")) {
			int content;
			System.out.println("The Content read from file: ");
			while ((content = reader.read()) != -1){
				System.out.print((char) content);
			}
        } catch (Exception ex) {
            System.out.println("err");
        }

    }
}
