package com.finance.monthly_gold_investment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.monthly_gold_investment.dto.ProductDTO;
import com.finance.monthly_gold_investment.entity.Product;
import com.finance.monthly_gold_investment.mapper.ProductMapper;
import com.finance.monthly_gold_investment.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<ProductDTO> getAllProducts() {
		return repo.findAll().stream().map(ProductMapper::toDto).collect(Collectors.toList());
	}

	public ProductDTO getProduct(Long id) {
		return repo.findById(id).map(ProductMapper::toDto).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public ProductDTO createProduct(ProductDTO dto) {
		Product product = ProductMapper.toEntity(dto);
		return ProductMapper.toDto(repo.save(product));
	}

	public ProductDTO updateProduct(Long id, ProductDTO dto) {
		Product existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		existing.setProductName(dto.getProductName());
		existing.setLiveRate(dto.getLiveRate());
		existing.setPreviousRate(dto.getPreviousRate());
		existing.setUpdateDate(dto.getUpdateDate());

		return ProductMapper.toDto(repo.save(existing));
	}

	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
}
