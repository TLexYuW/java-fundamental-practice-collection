package com.lex.practice.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : Lex Yu
 */
public class Demo2 {
	public static void main(String[] args) {
		Set<String> KeyWords = Collections.synchronizedSet(new TreeSet<>());

		String[] split_tags1 = {"1","2","3"};
		String[] split_tags2 = {"4","5","6"};

		KeyWords.addAll(Arrays.asList(split_tags1));
		KeyWords.addAll(Arrays.asList(split_tags2));

		System.out.println(KeyWords);
	}
}
