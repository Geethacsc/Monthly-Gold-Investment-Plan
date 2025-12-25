package com.finance.monthly_gold_investment.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name", unique = true, nullable = false, length = 900)
	private String productName;

	@Column(name = "live_rate", nullable = false)
	private Double liveRate;

	@Column(name = "previous_rate")
	private Double previousRate;

	@Column(name = "update_date", nullable = false)
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

	// getters & setters

}
