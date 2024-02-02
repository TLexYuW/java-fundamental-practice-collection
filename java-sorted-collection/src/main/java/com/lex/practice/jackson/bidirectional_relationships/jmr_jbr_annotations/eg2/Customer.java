package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg2;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author : Lex Yu
 */
public class Customer {
	private int id;
	private String name;
	@JsonManagedReference
	private Order order;

	public Customer() {
	}

	public Customer(int id, String name, Order order) {
		this.id = id;
		this.name = name;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
