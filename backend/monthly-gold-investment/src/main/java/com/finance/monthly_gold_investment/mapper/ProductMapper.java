package com.finance.monthly_gold_investment.mapper;

import com.finance.monthly_gold_investment.dto.ProductDTO;
import com.finance.monthly_gold_investment.entity.Product;

public class ProductMapper {

	public static ProductDTO toDto(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setLiveRate(product.getLiveRate());
		dto.setPreviousRate(product.getPreviousRate());
		dto.setUpdateDate(product.getUpdateDate());
		return dto;
	}

	public static Product toEntity(ProductDTO dto) {
		Product product = new Product();
		product.setProductId(dto.getProductId());
		product.setProductName(dto.getProductName());
		product.setLiveRate(dto.getLiveRate());
		product.setPreviousRate(dto.getPreviousRate());
		product.setUpdateDate(dto.getUpdateDate());
		return product;
	}
}
