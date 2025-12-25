package com.finance.monthly_gold_investment.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "scheme_info")
public class SchemeInfo {

	@Id
	@Column(name = "scheme_code", length = 100)
	private String groupCode;

	@Column(name = "scheme_name", length = 2000, nullable = false)
	private String schemeName;

	@Column(name = "scheme_type", length = 100, nullable = false)
	private String schemeType;

	@Column(name = "tot_ins", nullable = false)
	private int totalInstallments;

	@OneToMany(mappedBy = "schemeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InvestmentInfo> investmentInfoList;

	// Getters and Setters
	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public int getTotalInstallments() {
		return totalInstallments;
	}

	public void setTotalInstallments(int totalInstallments) {
		this.totalInstallments = totalInstallments;
	}

	public List<InvestmentInfo> getInvestmentInfoList() {
		return investmentInfoList;
	}

	public void setInvestmentInfoList(List<InvestmentInfo> investmentInfoList) {
		this.investmentInfoList = investmentInfoList;
	}

	public SchemeInfo(String groupCode) {
		super();
		this.groupCode = groupCode;
	}

	public SchemeInfo() {
		// TODO Auto-generated constructor stub
	}

}
