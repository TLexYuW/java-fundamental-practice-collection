package com.lex.practice.io.by.disdos;

import com.lex.practice.entity.Person;

import javax.xml.crypto.Data;
import java.io.*;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Dos {
	public static void main(String[] args) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("dosPeople.txt"))) {
			Person p1 = new Person("p1",100);
			Person p2 = new Person("p2",50);
			Person p3 = new Person("p3",25);
			dos.writeUTF(p1.getName() + ":" +  p1.getAge());
			dos.writeUTF(p2.getName() + ":" +  p2.getAge());
			dos.writeUTF(p3.getName() + ":" +  p3.getAge());
		} catch (Exception ex) {
			System.out.println("err");
		}
	}
}
