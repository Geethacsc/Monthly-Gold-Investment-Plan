package com.finance.monthly_gold_investment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.monthly_gold_investment.entity.PaymentTransaction;

public interface PaymentTransactionDAO extends JpaRepository<PaymentTransaction, Long> {

	Optional<PaymentTransaction> findByOrderId(String orderId);

    boolean existsByGatewayPaymentId(String gatewayPaymentId);
	
	
}
