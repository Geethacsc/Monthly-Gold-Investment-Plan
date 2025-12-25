package com.finance.monthly_gold_investment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.monthly_gold_investment.entity.User;
import com.finance.monthly_gold_investment.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);

	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {

		return service.verify(user);
	}
}