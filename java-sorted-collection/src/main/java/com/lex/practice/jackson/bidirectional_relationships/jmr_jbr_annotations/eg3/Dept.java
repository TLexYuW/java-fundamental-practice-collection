package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg3;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class Dept {
	private int deptId;
	@JsonManagedReference
	List<Employee> employees;
	private String name;

	public Dept() {

	}

	public Dept(int deptId, List<Employee> employees, String name) {
		this.deptId = deptId;
		this.employees = employees;
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
