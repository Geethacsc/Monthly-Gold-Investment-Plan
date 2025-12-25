package com.finance.monthly_gold_investment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.monthly_gold_investment.dto.SchemeInfoDTO;
import com.finance.monthly_gold_investment.service.SchemeInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/scheme-info")
public class SchemeInfoController {

	private final SchemeInfoService service;

	@Autowired
	public SchemeInfoController(SchemeInfoService service) {
		this.service = service;
	}

	@PostMapping("/create-group")
	public SchemeInfoDTO create(@RequestBody SchemeInfoDTO dto) {
		return service.create(dto);
	}

	@PutMapping("update-group/{groupCode}")
	public SchemeInfoDTO update(@PathVariable String groupCode, @RequestBody SchemeInfoDTO dto) {
		return service.update(groupCode, dto);
	}

	@DeleteMapping("delete-group/{groupCode}")
	public void delete(@PathVariable String groupCode) {
		service.delete(groupCode);
	}

	@GetMapping("get-group-by-id/{groupCode}")
	public SchemeInfoDTO getById(@PathVariable String groupCode) {
		return service.getById(groupCode);
	}

	@GetMapping("/get-scheme-details")
	public List<SchemeInfoDTO> getSchemeDetails() {
		return service.getAll();
	}
}
