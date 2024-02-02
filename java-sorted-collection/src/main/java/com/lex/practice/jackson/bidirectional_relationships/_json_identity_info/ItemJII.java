package com.lex.practice.jackson.bidirectional_relationships._json_identity_info;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author : Lex Yu
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class ItemJII {
	public int id;
	public String itemName;

	public UserJII owner;

	public ItemJII() {
	}

	public ItemJII(int id, String itemName, UserJII owner) {
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

	public UserJII getOwner() {
		return owner;
	}

	public void setOwner(UserJII owner) {
		this.owner = owner;
	}
}
