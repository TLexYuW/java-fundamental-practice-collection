package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setName("Tina");

		Employee emp2 = new Employee();
		emp2.setEmpId(2);
		emp2.setName("Joe");

		Dept dept = new Dept();
		dept.setName("IT");
		dept.setDeptId(3);
		dept.setEmployees(List.of(emp1, emp2));

		System.out.println("-- before serializing dept --");
		System.out.println(dept);

		System.out.println("-- json string after serializing --");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(dept);
		System.out.println(s);
		System.out.println("-- deserializing --");
		Dept dept1 = om.readValue(s, Dept.class);
		System.out.println(dept1);
	}
}
