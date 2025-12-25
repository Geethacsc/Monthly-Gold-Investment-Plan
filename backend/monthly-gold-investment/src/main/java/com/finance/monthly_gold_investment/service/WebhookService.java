package com.finance.monthly_gold_investment.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import com.finance.monthly_gold_investment.entity.InvestmentInfo;
import com.finance.monthly_gold_investment.entity.MGIPFlexi;
import com.finance.monthly_gold_investment.entity.PaymentTransaction;
import com.finance.monthly_gold_investment.entity.TransactionDetails;
import com.finance.monthly_gold_investment.repo.InvestmentInfoDAO;
import com.finance.monthly_gold_investment.repo.MGIPFlexiDAO;
import com.finance.monthly_gold_investment.repo.PaymentTransactionDAO;
import com.finance.monthly_gold_investment.repo.TransactionDetailsDAO;

public class WebhookService {

	private final PaymentTransactionDAO paymentRepo;
	private final InvestmentInfoDAO investmentRepo;
	private final TransactionDetailsDAO txnRepo;
	private final MGIPFlexiDAO mgipRepo;

	@Value("${razorpay.webhook-secret}")
	private String webhookSecret;

	public WebhookService(PaymentTransactionDAO paymentRepo, InvestmentInfoDAO investmentRepo,
			TransactionDetailsDAO txnRepo, MGIPFlexiDAO mgipRepo) {
		super();
		this.paymentRepo = paymentRepo;
		this.investmentRepo = investmentRepo;
		this.txnRepo = txnRepo;
		this.mgipRepo = mgipRepo;
	}

	public String handleWebhook(String payload, String signature) {
		JSONObject event = new JSONObject(payload);
		String type = event.getString("event");

		JSONObject entity = event.getJSONObject("payload").getJSONObject("payment").getJSONObject("entity");

		String orderId = entity.getString("order_id");
		String paymentId = entity.getString("id");
		Long amount = entity.getLong("amount") / 100;

		PaymentTransaction payment = paymentRepo.findByOrderId(orderId).orElseThrow();

		if (paymentRepo.existsByGatewayPaymentId(paymentId)) {
			return "Duplicate webhook ignored";
		}

		if ("payment.captured".equals(type)) {

			InvestmentInfo investment = investmentRepo
					.findById(payment.getTransactionDetails().getInvestmentInfo().getRegNo()).orElseThrow();

			int instNo = (int) txnRepo.countByInvestmentInfo(investment) + 1;

			TransactionDetails txn = new TransactionDetails();
			txn.setInstallmentNo(instNo);
			txn.setTypeOfTransaction("ONLINE");
			txn.setPaidDate(new java.sql.Date(System.currentTimeMillis()));
			txn.setAmount(amount);
			txn.setRateOnPay(0.0);
			txn.setWeight(0.0);
			txn.setInvestmentInfo(investment);

			txnRepo.save(txn);

			payment.setGatewayPaymentId(paymentId);
			payment.setPaymentStatus("SUCCESS");
			payment.setVerifiedAt(LocalDateTime.now());
			payment.setTransactionDetails(txn);

			paymentRepo.save(payment);

			MGIPFlexi mgip = mgipRepo.findById(investment.getMobileNo()).orElseThrow();

			mgip.setPaidInsts(mgip.getPaidInsts() + 1);
			mgip.setTotalPaidAmount(mgip.getTotalPaidAmount() + amount);
			mgip.setLastPaidDate(LocalDate.now());

			mgipRepo.save(mgip);
		}

		if ("payment.failed".equals(type)) {
			payment.setPaymentStatus("FAILED");
			paymentRepo.save(payment);
		}

		return "Processed";
	}
}