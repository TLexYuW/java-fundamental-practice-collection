package com.lex.practice.jackson.bidirectional_relationships.custom_serializer;

/**
 * @author : Lex Yu
 */
public class ItemCSL {
	public int id;
	public String itemName;

	public UserCSL owner;

	public ItemCSL() {
	}

	public ItemCSL(int id, String itemName, UserCSL owner) {
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

	public UserCSL getOwner() {
		return owner;
	}

	public void setOwner(UserCSL owner) {
		this.owner = owner;
	}
}
