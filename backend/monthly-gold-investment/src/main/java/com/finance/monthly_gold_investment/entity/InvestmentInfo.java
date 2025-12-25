package com.finance.monthly_gold_investment.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "investment_Info")
public class InvestmentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_no")
	private Long regNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_code", nullable = false)
	private SchemeInfo schemeInfo;

	@Column(name = "branch", length = 1000, nullable = false)
	private String branch;

	@Column(name = "amount", nullable = false)
	private Long amount;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "mature_date", nullable = false)
	private Date matureDate;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "mobile_no", length = 100, nullable = false)
	private String mobileNo;

	@Column(name = "email", length = 1000)
	private String email;

	@Column(name = "address", length = 4000)
	private String address;

	@OneToMany(mappedBy = "schemeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TransactionDetails> transactions;

	// Getters and Setters
	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public SchemeInfo getSchemeInfo() {
		return schemeInfo;
	}

	public void setSchemeInfo(SchemeInfo schemeInfo) {
		this.schemeInfo = schemeInfo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getMatureDate() {
		return matureDate;
	}

	public void setMatureDate(Date matureDate) {
		this.matureDate = matureDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<TransactionDetails> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDetails> transactions) {
		this.transactions = transactions;
	}
}
