package com.finance.monthly_gold_investment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.monthly_gold_investment.dto.TransactionDetailsDTO;
import com.finance.monthly_gold_investment.entity.InvestmentInfo;
import com.finance.monthly_gold_investment.entity.TransactionDetails;
import com.finance.monthly_gold_investment.mapper.TransactionDetailsMapper;
import com.finance.monthly_gold_investment.repo.InvestmentInfoDAO;
import com.finance.monthly_gold_investment.repo.TransactionDetailsDAO;
import com.finance.monthly_gold_investment.service.TransactionDetailsService;

@Service
@Transactional
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

	private final TransactionDetailsDAO txRepo;
	private final InvestmentInfoDAO investmentInfoDao;

	public TransactionDetailsServiceImpl(TransactionDetailsDAO txRepo, InvestmentInfoDAO investmentInfoDao) {
		this.txRepo = txRepo;
		this.investmentInfoDao = investmentInfoDao;
	}

	@Override
	public List<TransactionDetailsDTO> findAll() {
		return txRepo.findAll().stream().map(TransactionDetailsMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public TransactionDetailsDTO findById(Long id) {
		TransactionDetails t = txRepo.findById(id).orElseThrow();
		return TransactionDetailsMapper.toDto(t);
	}

	@Override
	public TransactionDetailsDTO create(TransactionDetailsDTO dto) {
		if (dto.getRegNo() == null)
			throw new IllegalArgumentException("regNo is required");
		InvestmentInfo investment = investmentInfoDao.findById(dto.getRegNo()).orElseThrow();
		TransactionDetails entity = TransactionDetailsMapper.toEntity(dto, investment);
		entity = txRepo.save(entity);
		return TransactionDetailsMapper.toDto(entity);
	}

	@Override
	public TransactionDetailsDTO update(Long id, TransactionDetailsDTO dto) {
		TransactionDetails existing = txRepo.findById(id).orElseThrow();
		existing.setInstallmentNo(dto.getInstNo());
		existing.setTypeOfTransaction(dto.getTypeOfTrans());
		existing.setRateOnPay(dto.getRateOnPay());
		existing.setPaidDate(dto.getPaidDate());
		existing.setAmount(dto.getAmount());
		existing.setReceiptNo(dto.getReceiptNo());
		existing.setWeight(dto.getWeight());

		if (dto.getRegNo() != null && !dto.getRegNo().equals(existing.getInvestmentInfo().getRegNo())) {
			InvestmentInfo investment = investmentInfoDao.findById(dto.getRegNo()).orElseThrow();
			existing.setInvestmentInfo(investment);
		}

		existing = txRepo.save(existing);
		return TransactionDetailsMapper.toDto(existing);
	}

	@Override
	public void delete(Long id) {
		txRepo.deleteById(id);
	}
}
