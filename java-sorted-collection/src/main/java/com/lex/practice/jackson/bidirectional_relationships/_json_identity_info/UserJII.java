package com.lex.practice.jackson.bidirectional_relationships._json_identity_info;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class UserJII {
	public int id;
	public String name;
	public List<ItemJII> userItems;

	public UserJII() {
	}

	public UserJII(int id, String name) {
		this.id = id;
		this.name = name;
		userItems = new ArrayList<>();
	}

	public UserJII(int id, String name, List<ItemJII> userItems) {
		this.id = id;
		this.name = name;
		this.userItems = userItems;
	}
	public void addItem(ItemJII item) {
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

	public List<ItemJII> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<ItemJII> userItems) {
		this.userItems = userItems;
	}
}
