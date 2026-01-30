package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg1;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class UserJMR {
	public int id;
	public String name;
	@JsonManagedReference
	public List<ItemJBR> userItems;

	public UserJMR() {
	}

	public UserJMR(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserJMR(int id, String name, List<ItemJBR> userItems) {
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

	public List<ItemJBR> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<ItemJBR> userItems) {
		this.userItems = userItems;
	}
}
