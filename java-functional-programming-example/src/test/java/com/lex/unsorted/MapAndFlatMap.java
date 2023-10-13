package com.lex.unsorted;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Lex Yu
 */
public class MapAndFlatMap {

	List<String[]> RawMaterials = new ArrayList<>();

	@BeforeEach
	public void init() {
		// First Box
		RawMaterials.add(new String[]{"Raw-Material-1", "Raw-Material-1", "Raw-Material-1", "Raw-Material-1", "Raw-Material-1"});
		// Second Box
		RawMaterials.add(new String[]{"Raw-Material-2", "Raw-Material-2", "Raw-Material-2", "Raw-Material-2", "Raw-Material-2"});
	}

	// Group
	static int group = 1;
	// Person
	static int person = 1;

	/**
	 * Two Boxes - Raw-Material-1, Raw-Material-2
	 * Process Raw Material to Product
	 */
	@Test
	public void map() {
		RawMaterials.forEach(stringArray -> System.out.println(Arrays.toString(stringArray)));

		System.out.println("===================================================================");

		RawMaterials
				.forEach(x -> System.out.println("Group-" + group++ + " : " + Arrays.toString(Arrays.stream(x).toArray())));
		 /*
        Console ================
        Group-1 : [Raw-Material-1, Raw-Material-1, Raw-Material-1, Raw-Material-1, Raw-Material-1]
		Group-2 : [Raw-Material-2, Raw-Material-2, Raw-Material-2, Raw-Material-2, Raw-Material-2]
         */

		System.out.println("===================================================================");

		RawMaterials.stream()
				.map(x -> Arrays.stream(x).map(y -> y.replace("Raw-Material", "Product")))
				.forEach(x -> System.out.println("Group-" + group++ + " : " + Arrays.toString(x.toArray())));
        /*
        Console ================
        Group-1 : [Product-1, Product-1, Product-1, Product-1, Product-1]
		Group-2 : [Product-2, Product-2, Product-2, Product-2, Product-2]
         */
	}

	/**
	 * Take two boxes of materials, process them into product,
	 * and then combine them into a total of 10 product,
	 * distributing them to 10 persons.
	 */
	@Test
	public void flatMap() {
		RawMaterials.forEach(stringArray -> System.out.println(Arrays.toString(stringArray)));

		System.out.println("===================================================================");

		RawMaterials
				.forEach(x -> Arrays.stream(x).forEach(e ->
						System.out.println("Person-" + person++ + " : " + e)
				));
         /*
        Console ================
        Person-1 : Raw-Material-1
		Person-2 : Raw-Material-1
		Person-3 : Raw-Material-1
		Person-4 : Raw-Material-1
		Person-5 : Raw-Material-1
		Person-6 : Raw-Material-2
		Person-7 : Raw-Material-2
		Person-8 : Raw-Material-2
		Person-9 : Raw-Material-2
		Person-10 : Raw-Material-2
         */

		System.out.println("===================================================================");

		RawMaterials.stream()
				.flatMap(x -> Arrays.stream(x).map(y -> y.replace("Raw-Material", "Product")))
				.forEach(x -> System.out.println("Person-" + person++ + " : " + x));
        /*
        Console ================
        Person-1 : Product-1
		Person-2 : Product-1
		Person-3 : Product-1
		Person-4 : Product-1
		Person-5 : Product-1
		Person-6 : Product-2
		Person-7 : Product-2
		Person-8 : Product-2
		Person-9 : Product-2
		Person-10 : Product-2
         */
	}

}
