package isp;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/8
 */
public class ThirdPartyPayment implements UnifiedPayment {
	@Override
	public void payMoney() {
		// Logic
	}

	@Override
	public void getScratchCard() {
		// Logic
	}

	// FIXME: ISP
	/*
	@Override
	public void getCashBackAsCreditBalance() {
		// ThirdPartyPayment Not Support This Feature
	}
	 */
}
