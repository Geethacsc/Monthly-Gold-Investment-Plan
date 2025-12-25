package com.finance.monthly_gold_investment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.monthly_gold_investment.dto.InvestmentInfoDTO;
import com.finance.monthly_gold_investment.service.InvestmentInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
@CrossOrigin
public class InvestmentInfoController {

	private final InvestmentInfoService service;

	@Autowired
	public InvestmentInfoController(InvestmentInfoService service) {
		this.service = service;
	}

	@GetMapping
	public List<InvestmentInfoDTO> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public InvestmentInfoDTO getOne(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public InvestmentInfoDTO create(@RequestBody InvestmentInfoDTO dto) {
		return service.create(dto);
	}

	@PutMapping("/{id}")
	public InvestmentInfoDTO update(@PathVariable Long id, @RequestBody InvestmentInfoDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
