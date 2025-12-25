package com.finance.monthly_gold_investment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.monthly_gold_investment.entity.Role;


@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

}
