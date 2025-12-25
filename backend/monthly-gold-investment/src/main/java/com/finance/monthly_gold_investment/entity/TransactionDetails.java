package com.finance.monthly_gold_investment.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trans_id")
	private Long transId;

	@Column(name = "inst_no", nullable = false)
	private int installmentNo;

	@Column(name = "type_of_trans", length = 100, nullable = false)
	private String typeOfTransaction;

	@Column(name = "rate_on_pay", nullable = false)
	private Double rateOnPay;

	@Column(name = "paid_date", nullable = false)
	private Date paidDate;

	@Column(name = "amount", nullable = false)
	private Long amount;

	@Column(name = "receipt_no")
	private Long receiptNo;

	@Column(name = "weight", nullable = false)
	private Double weight;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reg_no", nullable = false)
	private InvestmentInfo investmentInfo;

	
	public TransactionDetails() {
	}

	// Getters & Setters
	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public int getInstallmentNo() {
		return installmentNo;
	}

	public void setInstallmentNo(int installmentNo) {
		this.installmentNo = installmentNo;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
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

	public InvestmentInfo getInvestmentInfo() {
		return investmentInfo;
	}

	public void setInvestmentInfo(InvestmentInfo investmentInfo) {
		this.investmentInfo = investmentInfo;
	}

	
}
