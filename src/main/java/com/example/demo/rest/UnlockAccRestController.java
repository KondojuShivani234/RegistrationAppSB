package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.UnlockAccForm;
import com.example.demo.service.UserMgmtService;

@RestController
public class UnlockAccRestController {
	@Autowired
	private UserMgmtService userMgmtService;
	@PostMapping("/unlock")
	public String unlockAccount(@RequestBody UnlockAccForm unlockAccForm) {
		return userMgmtService.unlockAccount(unlockAccForm);

	}
}
