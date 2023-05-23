package com.lex.practice.con_hashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/23
 */
public class ThirdMain {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("UserA", 20);
		map.put("UserB", 50);
		map.put("UserC", 100);
		map.put("UserD", 200);
		map.put("UserE", 1300);
		map.put("UserF", 2000);
		map.put("UserG", 10000);

		// 1st, for-each entries
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		System.out.println("-------------------------------------------------");

		// 2nd, for-each keys or values
		for (String key : map.keySet()) {
			System.out.println("key = " + key);
		}
		for (Integer value : map.values()) {
			System.out.println("value = " + value);
		}
		System.out.println("-------------------------------------------------");

		// 3rd, Iterator
		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()){
			Map.Entry<String, Integer> entry = entries.next();
			System.out.println("Key = " + entry.getKey() + ", " + "Value = " + entry.getValue());
			if ("UserB".equals(entry.getKey())){
				map.remove(entry.getKey());
			}
		}
		System.out.println("-------------------------------------------------");

		// without generics
		Iterator entrys = map.entrySet().iterator();
		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String)entry.getKey();
			Integer value = (Integer)entry.getValue();
			System.out.println("Key = " + key + ", Value = " + value);
		}

		System.out.println("-------------------------------------------------");
		// 4th, not recommend
		for (String key : map.keySet()){
			Integer value = map.get(key);
			System.out.println("Key = " + key + ", Value = " + value);
		}
	}
}
