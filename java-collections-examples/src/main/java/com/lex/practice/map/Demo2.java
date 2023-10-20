package com.lex.practice.map;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/23
 */
public class Demo2 {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("UserA", 20);
		map.put("UserB", 50);
		map.put("UserC", 100);

		String output = map.reduce(3,
				(k, v) -> k + ":" + v,
				(s1, s2) -> s1 + ", " + s2);

		System.out.println("Output = " + output);
		System.out.println("-------------------------------------------------");
		map.keys().asIterator().forEachRemaining(System.out::println);
		System.out.println("-------------------------------------------------");
		System.out.println(map.keySet());
		System.out.println("-------------------------------------------------");
		Set keySet = map.keySet(100);
		keySet.add("UserD");
		keySet.add("UserE");
		System.out.println(map);
		System.out.println("-------------------------------------------------");
		System.out.println(map.keySet());
		System.out.println("-------------------------------------------------");
		System.out.println(map.values());
		System.out.println("-------------------------------------------------");

		ConcurrentHashMap<Integer, Integer> map2 = new ConcurrentHashMap<>();
		map2.put(5, 50);
		map2.put(7, 10);
		map2.put(9, 30);

		Integer output2 = map2.reduce(3,
				(k, v) -> k * v,
				(i1, i2) -> i1 + i2);

		System.out.println("Output2 = " + output2);
	}
}
