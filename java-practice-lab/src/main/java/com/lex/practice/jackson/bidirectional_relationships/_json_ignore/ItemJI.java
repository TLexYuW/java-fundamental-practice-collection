package com.lex.practice.jackson.bidirectional_relationships._json_ignore;


/**
 * @author : Lex Yu
 */

public class ItemJI {
	public int id;
	public String itemName;

	public UserJI owner;

	public ItemJI() {
	}

	public ItemJI(int id, String itemName, UserJI owner) {
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

	public UserJI getOwner() {
		return owner;
	}

	public void setOwner(UserJI owner) {
		this.owner = owner;
	}
}
