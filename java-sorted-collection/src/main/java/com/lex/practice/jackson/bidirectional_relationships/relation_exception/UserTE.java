package com.lex.practice.jackson.bidirectional_relationships.relation_exception;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class UserTE {
	public int id;
	public String name;
	public List<ItemTE> userItems;

	public UserTE() {
	}

	public UserTE(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserTE(int id, String name, List<ItemTE> userItems) {
		this.id = id;
		this.name = name;
		this.userItems = userItems;
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

	public List<ItemTE> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<ItemTE> userItems) {
		this.userItems = userItems;
	}
}
