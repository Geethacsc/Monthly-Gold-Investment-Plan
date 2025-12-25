package com.finance.monthly_gold_investment.service;

import java.util.List;

import com.finance.monthly_gold_investment.dto.SchemeInfoDTO;

public interface SchemeInfoService {

	SchemeInfoDTO create(SchemeInfoDTO dto);

	SchemeInfoDTO update(String groupCode, SchemeInfoDTO dto);

	void delete(String groupCode);

	SchemeInfoDTO getById(String groupCode);

	List<SchemeInfoDTO> getAll();
}
