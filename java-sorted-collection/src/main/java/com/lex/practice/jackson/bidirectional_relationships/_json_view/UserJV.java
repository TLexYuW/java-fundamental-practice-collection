package com.lex.practice.jackson.bidirectional_relationships._json_view;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 */
public class UserJV {
	@JsonView(Views.Public.class)
	public int id;

	@JsonView(Views.Public.class)
	public String name;

	@JsonView(Views.Internal.class)
	public List<ItemJV> userItems;

	public UserJV(int id, String name) {
		this.id = id;
		this.name = name;
		userItems = new ArrayList<>();
	}

	public void addItem(ItemJV item) {
		userItems.add(item);
	}

}
