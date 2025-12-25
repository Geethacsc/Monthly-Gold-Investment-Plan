package com.finance.monthly_gold_investment.dto;


import java.sql.Date;

public class TransactionDetailsDTO {

	private Long transId;
	private Integer instNo;
	private String typeOfTrans;
	private Double rateOnPay;
	private Date paidDate;
	private Long amount;
	private Long receiptNo;
	private Double weight;
	private Long regNo; // Foreign key reference to SchemeInfo

	// Getters and Setters

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public Integer getInstNo() {
		return instNo;
	}

	public void setInstNo(Integer instNo) {
		this.instNo = instNo;
	}

	public String getTypeOfTrans() {
		return typeOfTrans;
	}

	public void setTypeOfTrans(String typeOfTrans) {
		this.typeOfTrans = typeOfTrans;
	}

	public Double getRateOnPay() {
		return rateOnPay;
	}

	public void setRateOnPay(Double rateOnPay) {
		this.rateOnPay = rateOnPay;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}
}
