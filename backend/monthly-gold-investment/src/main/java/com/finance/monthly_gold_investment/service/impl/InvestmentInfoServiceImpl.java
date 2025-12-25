package com.finance.monthly_gold_investment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.monthly_gold_investment.dto.InvestmentInfoDTO;
import com.finance.monthly_gold_investment.entity.InvestmentInfo;
import com.finance.monthly_gold_investment.entity.SchemeInfo;
import com.finance.monthly_gold_investment.mapper.InvestmentInfoMapper;
import com.finance.monthly_gold_investment.repo.InvestmentInfoDAO;
import com.finance.monthly_gold_investment.service.InvestmentInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvestmentInfoServiceImpl implements InvestmentInfoService {

	private final InvestmentInfoDAO investmentInfoDAO;

	@Autowired
	public InvestmentInfoServiceImpl(InvestmentInfoDAO investmentInfoDAO) {
		this.investmentInfoDAO = investmentInfoDAO;
	}

	@Override
	public List<InvestmentInfoDTO> findAll() {
		return investmentInfoDAO.findAll().stream().map(InvestmentInfoMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public InvestmentInfoDTO findById(Long id) {
		InvestmentInfo e = investmentInfoDAO.findById(id).orElseThrow();
		return InvestmentInfoMapper.toDto(e);
	}

	@Override
	public InvestmentInfoDTO create(InvestmentInfoDTO dto) {
		InvestmentInfo entity = InvestmentInfoMapper.toEntity(dto);
		entity = investmentInfoDAO.save(entity);
		return InvestmentInfoMapper.toDto(entity);
	}

	@Override
	public InvestmentInfoDTO update(Long id, InvestmentInfoDTO dto) {
		InvestmentInfo existing = investmentInfoDAO.findById(id).orElseThrow();
		existing.setSchemeInfo(new SchemeInfo(dto.getGroupCode()));
		existing.setBranch(dto.getBranch());
		existing.setAmount(dto.getAmount());
		existing.setStartDate(dto.getStartDate());
		existing.setMatureDate(dto.getMatureDate());
		existing.setName(dto.getName());
		existing.setMobileNo(dto.getMobileNo());
		existing.setEmail(dto.getEmail());
		existing.setAddress(dto.getAddress());
		existing = investmentInfoDAO.save(existing);
		return InvestmentInfoMapper.toDto(existing);
	}

	@Override
	public void delete(Long id) {
		investmentInfoDAO.deleteById(id);
	}
}
