package com.finance.monthly_gold_investment.dto;

public class CreatePaymentRequest {

	private Long investmentRegNo;
	private Long amount;
	private String paymentMode; // UPI / CARD

	public Long getInvestmentRegNo() {
		return investmentRegNo;
	}

	public void setInvestmentRegNo(Long investmentRegNo) {
		this.investmentRegNo = investmentRegNo;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	// getters & setters

}
