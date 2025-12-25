package com.finance.monthly_gold_investment.mapper;

import com.finance.monthly_gold_investment.dto.InvestmentInfoDTO;
import com.finance.monthly_gold_investment.entity.InvestmentInfo;
import com.finance.monthly_gold_investment.entity.SchemeInfo;

public class InvestmentInfoMapper {

	public static InvestmentInfoDTO toDto(InvestmentInfo e) {
		if (e == null)
			return null;
		InvestmentInfoDTO d = new InvestmentInfoDTO();
		d.setRegNo(e.getRegNo());
		d.setGroupCode(e.getSchemeInfo().getGroupCode());
		d.setBranch(e.getBranch());
		d.setAmount(e.getAmount());
		d.setStartDate(e.getStartDate());
		d.setMatureDate(e.getMatureDate());
		d.setName(e.getName());
		d.setMobileNo(e.getMobileNo());
		d.setEmail(e.getEmail());
		d.setAddress(e.getAddress());
		return d;
	}

	public static InvestmentInfo toEntity(InvestmentInfoDTO d) {
		if (d == null)
			return null;
		InvestmentInfo e = new InvestmentInfo();
		e.setRegNo(d.getRegNo());
		
		e.setSchemeInfo(new SchemeInfo(d.getGroupCode()));
		e.setBranch(d.getBranch());
		e.setAmount(d.getAmount());
		e.setStartDate(d.getStartDate());
		e.setMatureDate(d.getMatureDate());
		e.setName(d.getName());
		e.setMobileNo(d.getMobileNo());
		e.setEmail(d.getEmail());
		e.setAddress(d.getAddress());
		return e;
	}
}
