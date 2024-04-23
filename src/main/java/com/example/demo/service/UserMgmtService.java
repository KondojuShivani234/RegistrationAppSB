package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.bindings.LoginForm;
import com.example.demo.bindings.UnlockAccForm;
import com.example.demo.bindings.UserRegForm;
@Service
public interface UserMgmtService {

	public String login(LoginForm loginForm);

	public String emailChecking(String emailId);

	public Map<Integer, String> countries();

	public Map<Integer, String> states(Integer countryId);

	public Map<Integer, String> cities(Integer stateId);

	public String register(UserRegForm userRegForm);

	public String unlockAccount(UnlockAccForm unlockAccForm);

	public String forgotPassword(String emailId);
}
