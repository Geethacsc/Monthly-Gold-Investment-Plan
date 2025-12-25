package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.monthly_gold_investment.entity.InvestmentInfo;
import com.finance.monthly_gold_investment.entity.TransactionDetails;

public interface TransactionDetailsDAO extends JpaRepository<TransactionDetails, Long> {

	int countByInvestmentInfo(InvestmentInfo investment);
}