package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg2;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class Order {
	private int orderId;
	private List<Integer> itemIds;
	@JsonBackReference
	private Customer customer;

	public Order() {

	}

	public Order(int orderId, List<Integer> itemIds, Customer customer) {
		this.orderId = orderId;
		this.itemIds = itemIds;
		this.customer = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Integer> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
