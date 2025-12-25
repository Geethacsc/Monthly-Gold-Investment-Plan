package com.finance.monthly_gold_investment.service;

import java.util.List;

import com.finance.monthly_gold_investment.dto.InvestmentInfoDTO;

public interface InvestmentInfoService {
    List<InvestmentInfoDTO> findAll();
    InvestmentInfoDTO findById(Long id);
    InvestmentInfoDTO create(InvestmentInfoDTO dto);
    InvestmentInfoDTO update(Long id, InvestmentInfoDTO dto);
    void delete(Long id);
}
