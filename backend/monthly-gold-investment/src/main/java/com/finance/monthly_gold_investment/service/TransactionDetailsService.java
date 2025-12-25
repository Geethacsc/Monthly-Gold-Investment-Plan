package com.finance.monthly_gold_investment.service;

import java.util.List;

import com.finance.monthly_gold_investment.dto.TransactionDetailsDTO;

public interface TransactionDetailsService {
    List<TransactionDetailsDTO> findAll();
    TransactionDetailsDTO findById(Long id);
    TransactionDetailsDTO create(TransactionDetailsDTO dto);
    TransactionDetailsDTO update(Long id, TransactionDetailsDTO dto);
    void delete(Long id);
}
