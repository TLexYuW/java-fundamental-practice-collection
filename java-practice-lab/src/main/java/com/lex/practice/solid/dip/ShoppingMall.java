package com.lex.practice.solid.dip;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/8
 */
public class ShoppingMall {

	private DebitCard debitCard;

	private CreditCard creditCard;

	public ShoppingMall(DebitCard debitCard, CreditCard creditCard) {
		this.debitCard = debitCard;
		this.creditCard = creditCard;
	}

	public static void main(String[] args) {

	}
}
