package com.finance.monthly_gold_investment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayClientService {

	@Value("${razorpay.key.id}")
	private String keyId;

	@Value("${razorpay.key.secret}")
	private String keySecret;

	public RazorpayClient getClient() throws RazorpayException {
		return new RazorpayClient(keyId, keySecret);
	}
}
