package com.lex.practice.jackson.bidirectional_relationships.custom_deserializer;

/**
 * @author : Lex Yu
 */
public class ItemCDSL {
	public int id;
	public String itemName;

	public UserCDSL owner;

	public ItemCDSL() {
	}

	public ItemCDSL(int id, String itemName, UserCDSL owner) {
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

	public UserCDSL getOwner() {
		return owner;
	}

	public void setOwner(UserCDSL owner) {
		this.owner = owner;
	}
}
