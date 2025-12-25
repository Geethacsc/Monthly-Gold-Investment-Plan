package com.finance.monthly_gold_investment.mapper;

import org.springframework.stereotype.Component;

import com.finance.monthly_gold_investment.dto.SchemeInfoDTO;
import com.finance.monthly_gold_investment.entity.SchemeInfo;

@Component
public class SchemeInfoMapper {

	public SchemeInfoDTO toDTO(SchemeInfo entity) {
		SchemeInfoDTO dto = new SchemeInfoDTO();
		dto.setGroupCode(entity.getGroupCode());
		dto.setSchemeName(entity.getSchemeName());
		dto.setSchemeType(entity.getSchemeType());
		dto.setTotalInstallments(entity.getTotalInstallments());
		return dto;
	}

	public SchemeInfo toEntity(SchemeInfoDTO dto) {
		SchemeInfo entity = new SchemeInfo();
		entity.setGroupCode(dto.getGroupCode());
		entity.setSchemeName(dto.getSchemeName());
		entity.setSchemeType(dto.getSchemeType());
		entity.setTotalInstallments(dto.getTotalInstallments());
		return entity;
	}
}
