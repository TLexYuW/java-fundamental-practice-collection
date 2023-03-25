package com.lex.practice.by.oisoos;

import com.lex.practice.entity.Person;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Ois {
	public static void main(String[] args) {
		try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream("oosPeople.bin"))) {
			while (true){
				try {
					Person p = (Person) oos.readObject();
					System.out.println(p);
				} catch (Exception ex) {
					System.out.println("end of file err");
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
