package com.lex.practice.jackson.bidirectional_relationships._json_ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 */

public class UserJI {
	public int id;
	public String name;
	@JsonIgnore
	public List<ItemJI> userItems;

	public UserJI() {
	}

	public UserJI(int id, String name) {
		this.id = id;
		this.name = name;
		userItems = new ArrayList<>();
	}

	public UserJI(int id, String name, List<ItemJI> userItems) {
		this.id = id;
		this.name = name;
		this.userItems = userItems;
	}
	public void addItem(ItemJI item) {
		userItems.add(item);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemJI> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<ItemJI> userItems) {
		this.userItems = userItems;
	}
}
