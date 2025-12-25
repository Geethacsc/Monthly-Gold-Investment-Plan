package com.finance.monthly_gold_investment.service;

import java.time.LocalDateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.finance.monthly_gold_investment.dto.CreatePaymentRequest;
import com.finance.monthly_gold_investment.entity.PaymentTransaction;
import com.finance.monthly_gold_investment.repo.PaymentTransactionDAO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class PaymentService {

	@Value("${razorpay.key.id}")
	private String keyId;

	@Value("${razorpay.key.secret}")
	private String razorpayKeySecret;

	private final RazorpayClient razorpay;
	private final PaymentTransactionDAO paymentRepo;

	public PaymentService(RazorpayClient razorpay, PaymentTransactionDAO paymentRepo) {
		this.paymentRepo = paymentRepo;
		this.razorpay = razorpay;
	}

	public PaymentTransaction createOrder(CreatePaymentRequest req) throws Exception {

		JSONObject order = new JSONObject();
		order.put("amount", req.getAmount() * 100);
		order.put("currency", "INR");
		order.put("payment_capture", 1);

		Order razorOrder = razorpay.orders.create(order);

		PaymentTransaction payment = new PaymentTransaction();
		payment.setOrderId(razorOrder.get("id"));
		payment.setAmount(req.getAmount());
		payment.setCurrency("INR");
		payment.setPaymentStatus("CREATED");
		payment.setPaymentMode(req.getPaymentMode());
		payment.setCreatedAt(LocalDateTime.now());

		return paymentRepo.save(payment);
	}

}
