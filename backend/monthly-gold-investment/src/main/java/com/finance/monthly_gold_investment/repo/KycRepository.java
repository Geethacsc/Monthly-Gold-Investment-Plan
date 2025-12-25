package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.monthly_gold_investment.entity.Kyc;

public interface KycRepository extends JpaRepository<Kyc, Long> {}
