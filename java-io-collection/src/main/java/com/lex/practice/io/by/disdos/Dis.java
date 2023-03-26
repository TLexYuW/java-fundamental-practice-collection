package com.lex.practice.io.by.disdos;

import com.lex.practice.entity.Person;

import java.io.*;
import java.util.Arrays;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Dis {
	public static void main(String[] args) {
		try (DataInputStream dis = new DataInputStream(new FileInputStream("dosPeople.txt"))) {

			Person p1 = readPerson(dis.readUTF());
			Person p2 = readPerson(dis.readUTF());
			Person p3 = readPerson(dis.readUTF());

			System.out.println(p1.getName() + " is " + p1.getAge() + " years old.");
			System.out.println(p2.getName() + " is " + p2.getAge() + " years old.");
			System.out.println(p3.getName() + " is " + p3.getAge() + " years old.");
		} catch (Exception ex) {
			System.out.println("err");
		}
	}
	private static Person readPerson(String data) {
		String[] fields = data.split(":");
		String name = fields[0];
		int age = Integer.parseInt(fields[1]);
		return new Person(name, age);
	}
}
