package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserMgmtService;
@RestController
public class ForgotPwdRestController {
	@Autowired
	private UserMgmtService userMgmtService;
@GetMapping("/email")
	public String forgotPassword(String emailId) {
		return userMgmtService.forgotPassword(emailId);

	}
}
