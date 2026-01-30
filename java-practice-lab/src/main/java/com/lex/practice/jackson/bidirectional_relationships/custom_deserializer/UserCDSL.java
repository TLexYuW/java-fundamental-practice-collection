package com.lex.practice.jackson.bidirectional_relationships.custom_deserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class UserCDSL {
	public int id;
	public String name;
	@JsonDeserialize(using = CustomListDeserializer.class)
	public List<ItemCDSL> userItems;

	public UserCDSL() {
	}

	public UserCDSL(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserCDSL(int id, String name, List<ItemCDSL> userItems) {
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

	public List<ItemCDSL> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<ItemCDSL> userItems) {
		this.userItems = userItems;
	}
}
