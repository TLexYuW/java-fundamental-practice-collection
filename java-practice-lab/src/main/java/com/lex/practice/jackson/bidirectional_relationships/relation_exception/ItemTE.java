package com.lex.practice.jackson.bidirectional_relationships.relation_exception;

/**
 * @author : Lex Yu
 */
public class ItemTE {
	public int id;
	public String itemName;

	public UserTE owner;

	public ItemTE() {
	}

	public ItemTE(int id, String itemName, UserTE owner) {
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

	public UserTE getOwner() {
		return owner;
	}

	public void setOwner(UserTE owner) {
		this.owner = owner;
	}
}
