package com.finance.monthly_gold_investment.repo;

import com.finance.monthly_gold_investment.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	List<UserRole> findByUserId(Long userId);

	List<UserRole> findByRoleId(Long roleId);
}
