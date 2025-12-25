package com.finance.monthly_gold_investment.controller;


import com.finance.monthly_gold_investment.dto.TransactionDetailsDTO;
import com.finance.monthly_gold_investment.service.TransactionDetailsService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionDetailsController {

	private final TransactionDetailsService service;

	public TransactionDetailsController(TransactionDetailsService service) {
		this.service = service;
	}

	@GetMapping
	public List<TransactionDetailsDTO> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public TransactionDetailsDTO getOne(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public TransactionDetailsDTO create(@RequestBody TransactionDetailsDTO dto) {
		return service.create(dto);
	}

	@PutMapping("/{id}")
	public TransactionDetailsDTO update(@PathVariable Long id, @RequestBody TransactionDetailsDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
