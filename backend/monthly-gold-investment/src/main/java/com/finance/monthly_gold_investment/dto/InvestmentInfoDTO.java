package com.finance.monthly_gold_investment.dto;

import java.sql.Date;

public class InvestmentInfoDTO {
	private Long regNo;
	private String groupCode;
	private String branch;
	private Long amount;
	private Date startDate;
	private Date matureDate;
	private String name;
	private String mobileNo;
	private String email;
	private String address;

	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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

	@Override
	public String toString() {
		return "SchemeInfoDto [regNo=" + regNo + ", groupCode=" + groupCode + ", branch=" + branch + ", amount="
				+ amount + ", startDate=" + startDate + ", matureDate=" + matureDate + ", name=" + name + ", mobileNo="
				+ mobileNo + ", email=" + email + ", address=" + address + "]";
	}

}
