package com.finance.monthly_gold_investment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.monthly_gold_investment.dto.ProductDTO;
import com.finance.monthly_gold_investment.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<ProductDTO> getAll() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ProductDTO getOne(@PathVariable Long id) {
		return productService.getProduct(id);
	}

	@PostMapping
	public ProductDTO create(@RequestBody ProductDTO dto) {
		return productService.createProduct(dto);
	}

	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO dto) {
		return productService.updateProduct(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
