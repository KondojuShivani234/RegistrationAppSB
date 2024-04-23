package com.example.demo.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.UserRegForm;
import com.example.demo.service.UserMgmtService;

@RestController
public class RegistrationRestController {
	@Autowired
	private UserMgmtService userMgmtService;

	
	  @PostMapping("/user")
	public String userRegistration(@RequestBody UserRegForm userRegForm) {
      return userMgmtService.register(userRegForm);

	  
	  }

	@GetMapping("/email/{emailId}")
	public String emailChecking(@PathVariable("emailId") String emailId) {
		return userMgmtService.emailChecking(emailId);

	}

	@GetMapping("/countries")
	public Map<Integer, String> getCountries() {
		return userMgmtService.countries();
	}

	@GetMapping("/states/{countryId}")
	public Map<Integer, String> getStates(@PathVariable("countryId") Integer countryId) {
		return userMgmtService.states(countryId);

	}

}
