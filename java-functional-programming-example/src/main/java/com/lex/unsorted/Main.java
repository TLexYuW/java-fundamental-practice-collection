package com.lex.unsorted;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 2, 3);
		List<Integer> b = Arrays.asList(4, 5);
		List<Integer> c = Arrays.asList(6, 7, 8);

		List<List<Integer>> listOfListsOfInts = Arrays.asList(a, b, c);

		System.out.println("Before flattening: " + listOfListsOfInts);

		/* map() Still List of Lists Of Ints
		List<Integer> listOfInts = listOfListOfInts.stream()
				.map(list -> list.stream().collect(Collectors.toList()))
				.collect(Collectors.toList());
		 */

		List<Integer> listOfInts = listOfListsOfInts.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		System.out.println("After flattening  : " + listOfInts);


	}

}
