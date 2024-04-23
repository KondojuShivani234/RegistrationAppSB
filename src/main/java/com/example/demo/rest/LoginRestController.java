package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.LoginForm;
import com.example.demo.service.UserMgmtService;

@RestController
public class LoginRestController {
	@Autowired
	private UserMgmtService userMgmtService;
@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		return userMgmtService.login(loginForm);

	}
}
