package com.finance.monthly_gold_investment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.monthly_gold_investment.dto.SchemeInfoDTO;
import com.finance.monthly_gold_investment.entity.SchemeInfo;
import com.finance.monthly_gold_investment.mapper.SchemeInfoMapper;
import com.finance.monthly_gold_investment.repo.SchemeInfoDAO;
import com.finance.monthly_gold_investment.service.SchemeInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchemeInfoServiceImpl implements SchemeInfoService {

	private final SchemeInfoDAO schemeInfoDAO;
	private final SchemeInfoMapper mapper;

	@Autowired
	public SchemeInfoServiceImpl(SchemeInfoDAO schemeInfoDAO, SchemeInfoMapper mapper) {
		this.schemeInfoDAO = schemeInfoDAO;
		this.mapper = mapper;
	}

	@Override
	public SchemeInfoDTO create(SchemeInfoDTO dto) {
		SchemeInfo entity = mapper.toEntity(dto);
		return mapper.toDTO(schemeInfoDAO.save(entity));
	}

	@Override
	public SchemeInfoDTO update(String groupCode, SchemeInfoDTO dto) {
		SchemeInfo existing = schemeInfoDAO.findById(groupCode).orElseThrow(() -> new RuntimeException("Group not found"));

		existing.setSchemeName(dto.getSchemeName());
		existing.setSchemeType(dto.getSchemeType());
		existing.setTotalInstallments(dto.getTotalInstallments());

		return mapper.toDTO(schemeInfoDAO.save(existing));
	}

	@Override
	public void delete(String groupCode) {
		schemeInfoDAO.deleteById(groupCode);
	}

	@Override
	public SchemeInfoDTO getById(String groupCode) {
		SchemeInfo entity = schemeInfoDAO.findByGroupCode(groupCode).orElseThrow(() -> new RuntimeException("Group not found"));
		return mapper.toDTO(entity);
	}

	@Override
	public List<SchemeInfoDTO> getAll() {
		return schemeInfoDAO.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
	}
}
