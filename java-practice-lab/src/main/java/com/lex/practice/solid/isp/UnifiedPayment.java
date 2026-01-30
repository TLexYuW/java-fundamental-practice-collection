package com.lex.practice.solid.isp;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/8
 */
public interface UnifiedPayment {
	void payMoney();

	void getScratchCard();

	// FIXME: ISP
	/*
	void getCashBackAsCreditBalance();
	 */
}
