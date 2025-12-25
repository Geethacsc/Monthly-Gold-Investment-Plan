package com.finance.monthly_gold_investment.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MGIPF")
public class MGIPFlexi {

	@Id
	@Column(name = "account", length = 900)
	private String account;

	@Column(name = "name", nullable = false, length = 200)
	private String name;

	@Column(name = "mobile_no", nullable = false, length = 12)
	private String mobileNo;

	@Column(name = "paid_insts", nullable = false)
	private Integer paidInsts;

	@Column(name = "total_weight", nullable = false)
	private Double totalWeight;

	@Column(name = "tot_paid_amount", nullable = false)
	private Long totalPaidAmount;

	@Column(name = "last_paid_date", nullable = false)
	private LocalDate lastPaidDate;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getPaidInsts() {
		return paidInsts;
	}

	public void setPaidInsts(Integer paidInsts) {
		this.paidInsts = paidInsts;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Long getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public void setTotalPaidAmount(Long totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}

	public LocalDate getLastPaidDate() {
		return lastPaidDate;
	}

	public void setLastPaidDate(LocalDate lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}

	// getters & setters
}
