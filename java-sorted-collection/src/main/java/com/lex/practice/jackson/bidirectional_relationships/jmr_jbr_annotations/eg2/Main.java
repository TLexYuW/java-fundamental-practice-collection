package com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		Order order = new Order();
		order.setOrderId(1);
		order.setItemIds(List.of(10, 30));

		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Peter");
		customer.setOrder(order);
		order.setCustomer(customer);

		System.out.println(customer);
		System.out.println("-- serializing --");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(customer);
		System.out.println(s);
		System.out.println("-- deserializing --");
		Customer customer2 = om.readValue(s, Customer.class);
		System.out.println(customer2);
	}
}
