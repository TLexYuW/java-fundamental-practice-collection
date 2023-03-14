package com.lex.practice.dailycodebuffer.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/13
 */
public class Main {
	public static void main(String[] args) {
		Map<String, Integer> employees = new HashMap<>(); // transient Node<K,V>[] table; Node, LinkedList
		employees.put("K", 100); // hashcode(), hashing()
		employees.put("L", 101);
		employees.put("J", 1000);


		System.out.println("emp K hashcode value = " + employees.get("K").hashCode());
		System.out.println("emp L hashcode value = " + employees.get("L").hashCode());
		System.out.println("emp J hashcode value = " + employees.get("J").hashCode());
		System.out.println("emp hashcode value = " + employees.hashCode());

	}
}
