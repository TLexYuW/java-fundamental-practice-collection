package com.lex.practice.jackson.bidirectional_relationships._json_view;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author : Lex Yu
 */
public class ItemJV {
	@JsonView(Views.Public.class)
	public int id;

	@JsonView(Views.Public.class)
	public String itemName;

	@JsonView(Views.Public.class)
	public UserJV owner;

	public ItemJV(int id, String itemName, UserJV owner) {
		this.id = id;
		this.itemName = itemName;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public UserJV getOwner() {
		return owner;
	}

	public void setOwner(UserJV owner) {
		this.owner = owner;
	}
}
