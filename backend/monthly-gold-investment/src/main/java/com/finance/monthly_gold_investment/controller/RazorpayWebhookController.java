package com.finance.monthly_gold_investment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finance.monthly_gold_investment.service.WebhookService;
import com.finance.monthly_gold_investment.util.WebhookSignatureUtil;

@RestController
@RequestMapping("/api/razorpay/webhook")
public class RazorpayWebhookController {

	@Value("${razorpay.webhook.secret}")
	private String webhookSecret;

	private final WebhookService webhookService;

	@Autowired
	public RazorpayWebhookController(WebhookService webhookService) {
		this.webhookService = webhookService;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<String> handleWebhook(@RequestBody String payload,
			@RequestHeader("X-Razorpay-Signature") String signature) {

		if (!WebhookSignatureUtil.verify(payload, signature, webhookSecret)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signature");
		}

		return ResponseEntity.ok(webhookService.handleWebhook(payload, signature));
	}

}
