package com.finance.monthly_gold_investment.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finance.monthly_gold_investment.dto.CreatePaymentRequest;
import com.finance.monthly_gold_investment.entity.PaymentTransaction;
import com.finance.monthly_gold_investment.service.PaymentService;
import com.razorpay.RazorpayException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/razorpay")
@CrossOrigin
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/create-order")
	public PaymentTransaction createOrder(@RequestBody CreatePaymentRequest request) throws RazorpayException {

		try {
			return paymentService.createOrder(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
