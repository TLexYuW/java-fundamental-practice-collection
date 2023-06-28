package com.lex.practice.oop_concepts.aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/6/28
 */
// Class 1
// Student class
class Student {

	// Attributes of student
	String name;
	int id;
	String dept;

	// Constructor of student class
	Student(String name, int id, String dept) {
		// This keyword refers to current instance itself
		this.name = name;
		this.id = id;
		this.dept = dept;
	}
}

// Class 2
// Department class contains list of student objects
// It is associated with student class through its Objects
class Department {
	// Attributes of Department class
	String name;
	private List<Student> students;

	Department(String name, List<Student> students) {
		// this keyword refers to current instance itself
		this.name = name;
		this.students = students;
	}

	// Method of Department class
	public List<Student> getStudents() {
		// Returning list of user defined type
		// Student type
		return students;
	}
}

// Class 3
//  Institute class contains list of Department
// Objects. It is associated with Department
// class through its Objects
class Institute {

	// Attributes of Institute
	String instituteName;
	private List<Department> departments;

	// Constructor of institute class
	Institute(String instituteName, List<Department> departments) {
		// This keyword refers to current instance itself
		this.instituteName = instituteName;
		this.departments = departments;
	}

	// Method of Institute class
	// Counting total students of all departments
	// in a given institute
	public int getTotalStudentsInInstitute() {
		int noOfStudents = 0;
		List<Student> students;

		for (Department dept : departments) {
			students = dept.getStudents();

			for (Student s : students) {
				noOfStudents++;
			}
		}
		return noOfStudents;
	}
}

public class Aggregation {
	public static void main(String[] args) {
		// Creating object of Student class inside main()
		Student s1 = new Student("Mia", 1, "CSE");
		Student s2 = new Student("Priya", 2, "CSE");
		Student s3 = new Student("John", 1, "EE");
		Student s4 = new Student("Rahul", 2, "EE");

		// Creating a List of CSE Students
		List<Student> cse_students = new ArrayList<Student>();

		// Adding CSE students
		cse_students.add(s1);
		cse_students.add(s2);

		// Creating a List of EE Students
		List<Student> ee_students = new ArrayList<Student>();

		// Adding EE students
		ee_students.add(s3);
		ee_students.add(s4);

		// Creating objects of EE and CSE class inside
		// main()
		Department CSE = new Department("CSE", cse_students);
		Department EE = new Department("EE", ee_students);

		List<Department> departments = new ArrayList<Department>();
		departments.add(CSE);
		departments.add(EE);

		// Lastly creating an instance of Institute
		Institute institute = new Institute("BITS", departments);

		// Display message for better readability
		// Calling method to get total number of students
		// in institute and printing on console
		System.out.printf("Total students in institute: %s", institute.getTotalStudentsInInstitute());

	}
}
