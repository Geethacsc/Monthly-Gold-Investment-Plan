package com.finance.monthly_gold_investment.dto;

import java.time.LocalDate;

public class ProductDTO {
	
	private Long productId;
	private String productName;
	private Double liveRate;
	private Double previousRate;
	private LocalDate updateDate;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getLiveRate() {
		return liveRate;
	}

	public void setLiveRate(Double liveRate) {
		this.liveRate = liveRate;
	}

	public Double getPreviousRate() {
		return previousRate;
	}

	public void setPreviousRate(Double previousRate) {
		this.previousRate = previousRate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

}