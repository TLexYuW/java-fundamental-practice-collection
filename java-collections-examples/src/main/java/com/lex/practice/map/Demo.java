package com.lex.practice.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/22
 */
public class Demo {
	public static void main(String[] args) {
		// Creating a hashmap of even numbers
		HashMap<String, Integer> evenNumbers = new HashMap<>();
		evenNumbers.put("Two", 2);
		evenNumbers.put("Four", 4);
		System.out.println("HashMap = " + evenNumbers);
		System.out.println("-------------------------------------------------");

		// Creating ConcurrentHashMap from Other Maps
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(evenNumbers);
		map.put("Nine", 9);
		System.out.println("ConcurrentHashMap = " + map);
		System.out.println("-------------------------------------------------");

		// Insert Elements
		map.putIfAbsent("Six", 6);
		System.out.println("-------------------------------------------------");

		ConcurrentHashMap<String, Integer> numbers = new ConcurrentHashMap<>();
		numbers.put("One", 1);
		numbers.put("Three", 3);
		numbers.put("Twelve", 12);
		numbers.put("TwelveV2", 12);

		map.putAll(numbers);

		System.out.println("ConcurrentHashMap = " + map);
		System.out.println("-------------------------------------------------");

		// Access ConcurrentHashMap Elements
		// returns a set of all the key/value mapping of the map
		System.out.println("Key/Value mappings = " + map.entrySet());
		System.out.println("-------------------------------------------------");

		// returns a set of all the keys of the map
		System.out.println("Keys = " + map.keySet());
		System.out.println("-------------------------------------------------");

		// returns a set of all the values of the map
		System.out.println("Values mappings = " + map.values());
		System.out.println("-------------------------------------------------");

		// Returns the value associated with the specified key. Returns null if the key is not found.
		System.out.println("Using get() = " + map.get("Six"));
		System.out.println("-------------------------------------------------");

		// Returns the value associated with the specified key. Returns the specified default value if the key is not found.
		System.out.println("Using getOrDefault() = " + map.getOrDefault("rewokldsfmgks", 1_000_000));
		System.out.println("-------------------------------------------------");

		// Remove ConcurrentHashMap Elements
		boolean result = map.remove("Six", 6);
		System.out.println("Is the entry {Six=3} removed? " + result);
		System.out.println("map = " + map);
		System.out.println("-------------------------------------------------");

		// Bulk ConcurrentHashMap Operations
		// foreach
		map.forEach(6, (k, v) -> System.out.println("Key: " + k + ", value: " + v));
		System.out.println("-------------------------------------------------");

		map.forEach(6, (k, v) -> v, (v) -> System.out.print(v + ", "));
		System.out.println("-------------------------------------------------");

		map.forEachEntry(6, entry -> System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue()));
		System.out.println("-------------------------------------------------");

		map.forEachKey(6, k -> System.out.println("Key: " + k));
		System.out.println("-------------------------------------------------");

		map.forEachValue(6, v -> System.out.println("Value: " + v));
		System.out.println("-------------------------------------------------");

		// search()
		String key = map.search(6, (k, v) -> v == 12 ? k : null);
		System.out.println("search key = " + key);
		System.out.println("-------------------------------------------------");

		Map.Entry entry_ =
				map.searchEntries(6, (entry) -> {
					System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
					return entry.getValue() == 12 ? entry : null;
				});
		System.out.println("Entry_ = " + entry_);
		System.out.println("-------------------------------------------------");

		String key_ = map.searchKeys(6, k_e_y -> {
			System.out.println("searchKeys Key: " + k_e_y);
			return k_e_y.equals("One") ? k_e_y : null;
		});
		System.out.println("key_ = " + key_);
		System.out.println("-------------------------------------------------");

		Integer num = map.searchValues(6, value_ -> {
			System.out.println("searchValues Value: " + value_);
			return value_ == 3 ? value_ : null;
		});
		System.out.println("num = " + num);
		System.out.println("-------------------------------------------------");

		// reduce()
		String str = map.reduce(6, (_k_, v) -> _k_ + "---" + v, (s1, s2) -> s1 + ", " + s2);
		System.out.println("reduce str = " + str);
		System.out.println("-------------------------------------------------");

		// (k, v) -> v is a transformer function. It transfers the key/value mappings into values only.
		// (v1, v2) -> v1+v2 is a reducer function. It gathers together all the values and adds all values.
		int sum = map.reduce(6, (k_, v) -> v, (v1, v2) -> v1 + v2);
		System.out.println("Sum of Values = " + sum);
		System.out.println("-------------------------------------------------");

		Map.Entry reduceEntry = map.reduceEntries(6,
				(e) -> {
					System.out.println("reduceEntries transform => " + e.getKey() + ", " + e.getValue());
					return e;
				}
				, (e1, e2) -> {
					System.out.println("reduceEntries reducer => " + e1 + ", " + e2);
					if (e1.getKey().equals("Twelve")) {
						return e1;
					}
					return e2;
				});
		System.out.println("ReduceEntry = " + reduceEntry);
		System.out.println("-------------------------------------------------");

		String _key_ = map.reduceKeys(6, (k1, k2) -> {
			System.out.println("reduceKeys Reducer => " + k1 + "," + k2);
			return k1 + "," + k2;
		});
		System.out.println("_key_ = " + _key_);
		System.out.println("-------------------------------------------------");

		int total = map.reduceValues(6, (v1, v2) -> {
			System.out.println("reduceValues Reducer => " + v1 + "," + v2);
			return v1 + v2;
		});
		System.out.println("total = " + total);
		System.out.println("-------------------------------------------------");

	}
}
