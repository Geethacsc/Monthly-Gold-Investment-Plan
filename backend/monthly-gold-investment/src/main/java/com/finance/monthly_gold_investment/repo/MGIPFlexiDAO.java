package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.monthly_gold_investment.entity.MGIPFlexi;

public interface MGIPFlexiDAO extends JpaRepository<MGIPFlexi, String> {
}