package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg3;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author : Lex Yu
 */
public class Employee {
	private int empId;
	@JsonBackReference
	private Dept dept;
	private String name;

	public Employee(int empId, Dept dept, String name) {
		this.empId = empId;
		this.dept = dept;
		this.name = name;
	}

	public Employee() {
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
