package com.finance.monthly_gold_investment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.monthly_gold_investment.entity.SchemeInfo;

public interface SchemeInfoDAO extends JpaRepository<SchemeInfo, String> {
	
	Optional<SchemeInfo> findByGroupCode(String groupCode);

}