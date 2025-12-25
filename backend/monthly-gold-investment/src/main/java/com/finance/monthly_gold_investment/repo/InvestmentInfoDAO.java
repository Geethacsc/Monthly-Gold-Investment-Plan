package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finance.monthly_gold_investment.entity.InvestmentInfo;

public interface InvestmentInfoDAO extends JpaRepository<InvestmentInfo, Long> {

}
