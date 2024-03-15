package com.lex.practice.spi;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class FileSearch implements Search {
	@Override
	public List<String> searchDoc(String keyword) {
		System.out.println("Documentation Search " + keyword);
		return null;
	}
}
