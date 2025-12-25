package com.finance.monthly_gold_investment.mapper;

import com.finance.monthly_gold_investment.dto.TransactionDetailsDTO;
import com.finance.monthly_gold_investment.entity.InvestmentInfo;
import com.finance.monthly_gold_investment.entity.TransactionDetails;

public class TransactionDetailsMapper {

	public static TransactionDetailsDTO toDto(TransactionDetails e) {
		if (e == null)
			return null;
		TransactionDetailsDTO d = new TransactionDetailsDTO();
		d.setTransId(e.getTransId());
		d.setInstNo(e.getInstallmentNo());
		d.setTypeOfTrans(e.getTypeOfTransaction());
		d.setRateOnPay(e.getRateOnPay());
		d.setPaidDate(e.getPaidDate());
		d.setAmount(e.getAmount());
		d.setReceiptNo(e.getReceiptNo());
		d.setWeight(e.getWeight());
		d.setRegNo(e.getInvestmentInfo() != null ? e.getInvestmentInfo().getRegNo() : null);
		return d;
	}

	public static TransactionDetails toEntity(TransactionDetailsDTO d, InvestmentInfo investmentInfo) {
		if (d == null)
			return null;
		TransactionDetails e = new TransactionDetails();
		e.setTransId(d.getTransId());
		e.setInstallmentNo(d.getInstNo());
		e.setTypeOfTransaction(d.getTypeOfTrans());
		e.setRateOnPay(d.getRateOnPay());
		e.setPaidDate(d.getPaidDate());
		e.setAmount(d.getAmount());
		e.setReceiptNo(d.getReceiptNo());
		e.setWeight(d.getWeight());
		e.setInvestmentInfo(investmentInfo);
		return e;
	}
}
