package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.monthly_gold_investment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}