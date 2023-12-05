package com.lex.generic_method;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : Lex Yu
 */
public class Demo {
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
		List<String> list = Demo.fromArrayToList(intArray, Object::toString);

		System.out.println(list);
	}

	public <T> List<T> fromArrayToList(T[] a) {
		return Arrays.stream(a).collect(Collectors.toList());
	}

	public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
		return Arrays.stream(a)
				.map(mapperFunction)
				.collect(Collectors.toList());
	}

	// Bounded Generic
	public <T extends Number> List<T> fromArrayToList(T[] a) {
		return Arrays.stream(a).collect(Collectors.toList());
	}

	// Multiple Bounds
	public <T extends Number & Comparable<T>> List<T> fromArrayToList2(T[] a) {
		return Arrays.stream(a).collect(Collectors.toList());
	}

	/*
	public static void paintAllBuildings(List<Building> buildings) {
		buildings.forEach(Building::paint);
	}

	public static void paintAllBuildings(List<? extends Building> buildings) {
    ...
	}
	 */

}


