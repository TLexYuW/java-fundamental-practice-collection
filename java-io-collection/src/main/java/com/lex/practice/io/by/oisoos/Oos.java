package com.lex.practice.io.by.oisoos;

import com.lex.practice.entity.Person;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Oos {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oosPeople.bin"))) {

			Person p1 = new Person("p1",100);
			Person p2 = new Person("p2",50);
			Person p3 = new Person("p3",25);

			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(p3);
		} catch (Exception ex) {
			System.out.println("err");
		}

	}
}
