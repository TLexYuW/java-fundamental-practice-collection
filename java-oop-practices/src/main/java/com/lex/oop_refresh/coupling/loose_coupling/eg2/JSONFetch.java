package com.lex.oop_refresh.coupling.loose_coupling.eg2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/9/5
 */
public class JSONFetch implements FetchMetadata {
	@Override
	public List<Object> fetchMetadata() {
		System.out.println("Fetch Metadata From JSON ...");
		List<Object> metadata = new ArrayList<>();
		return metadata;
	}
}
