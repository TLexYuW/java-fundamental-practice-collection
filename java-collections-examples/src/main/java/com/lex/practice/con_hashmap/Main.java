package com.lex.practice.con_hashmap;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/22
 */
public class Main {
	public static void main(String[] args) {
		// Creating a hashmap of even numbers
		HashMap<String, Integer> evenNumbers = new HashMap<>();
		evenNumbers.put("Two", 2);
		evenNumbers.put("Four", 4);
		System.out.println("HashMap = " + evenNumbers);

		// Creating ConcurrentHashMap from Other Maps
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(evenNumbers);
		map.put("Nine", 9);
		System.out.println("ConcurrentHashMap = " + map);

		// Insert Elements
		map.putIfAbsent("Six", 6);

		ConcurrentHashMap<String, Integer> numbers = new ConcurrentHashMap<>();
		numbers.put("One", 1);
		numbers.put("Three", 3);
		numbers.put("Twelve", 12);

		map.putAll(numbers);

		System.out.println("ConcurrentHashMap = " + map);

		// Access ConcurrentHashMap Elements
		// returns a set of all the key/value mapping of the map
		System.out.println("Key/Value mappings = " + map.entrySet());

		// returns a set of all the keys of the map
		System.out.println("Keys = " + map.keySet());

		// returns a set of all the values of the map
		System.out.println("Values mappings = " + map.values());

		// Returns the value associated with the specified key. Returns null if the key is not found.
		System.out.println("Using get() = " + map.get("Six"));

		// Returns the value associated with the specified key. Returns the specified default value if the key is not found.
		System.out.println("Using getOrDefault() = " + map.getOrDefault("rewokldsfmgks",1_000_000));

		// Remove ConcurrentHashMap Elements
		boolean result = map.remove("Six", 6);
		System.out.println("Is the entry {Six=3} removed? " + result);

		// Bulk ConcurrentHashMap Operations
	}
}
