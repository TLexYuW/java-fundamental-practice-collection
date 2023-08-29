package com.lex.oop_concepts.association;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Lex Yu
 * @date : 2023/6/28
 */
class Bank {
	// Attributes of bank
	private String name;

	private Set<Employee> employees;

	// Constructor of this class
	Bank(String name) {
		// this keyword refers to current instance itself
		this.name = name;
	}

	// Method of Bank class
	public String getBankName() {
		// Returning name of bank
		return this.name;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Employee>
	getEmployees(Set<Employee> employees) {
		return this.employees;
	}
}

// Class 2
// Employee class
class Employee {
	// Attributes of employee
	private String name;

	// Employee name
	Employee(String name) {
		// This keyword refers to current instance itself
		this.name = name;
	}

	// Method of Employee class
	public String getEmployeeName() {
		// returning the name of employee
		return this.name;
	}
}

// Association between both the
// classes in main method
public class Association {
	public static void main(String[] args) {
		// Creating objects of bank and Employee class
		Bank bank = new Bank("LCorp");
		Employee employee = new Employee("Emp 1");

		Set<Employee> employees = new HashSet<>();
		employees.add(employee);

		bank.setEmployees(employees);

		System.out.printf("""
				%s belongs to bank %s
				""", employee.getEmployeeName(), bank.getBankName());
	}

}

