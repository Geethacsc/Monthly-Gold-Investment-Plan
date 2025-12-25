package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.monthly_gold_investment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailId(String email);
}
