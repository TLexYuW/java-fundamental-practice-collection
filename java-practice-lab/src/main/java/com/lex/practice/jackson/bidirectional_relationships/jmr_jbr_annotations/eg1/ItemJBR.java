package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg1;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author : Lex Yu
 */
public class ItemJBR {
	public int id;
	public String itemName;

	@JsonBackReference
	public UserJMR owner;

	public ItemJBR() {
	}

	public ItemJBR(int id, String itemName, UserJMR owner) {
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

	public UserJMR getOwner() {
		return owner;
	}

	public void setOwner(UserJMR owner) {
		this.owner = owner;
	}
}
