package com.lex.practice.jackson.bidirectional_relationships.custom_serializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class UserCSL {
	public int id;
	public String name;

	@JsonSerialize(using = CustomListSerializer.class)
	public List<ItemCSL> userItems;

	public UserCSL() {
	}

	public UserCSL(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserCSL(int id, String name, List<ItemCSL> userItems) {
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

	public List<ItemCSL> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<ItemCSL> userItems) {
		this.userItems = userItems;
	}
}
