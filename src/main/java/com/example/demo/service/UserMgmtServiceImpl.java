package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bindings.LoginForm;
import com.example.demo.bindings.UnlockAccForm;
import com.example.demo.bindings.UserRegForm;
import com.example.demo.entity.CityMasterEntity;
import com.example.demo.entity.CountryMasterEntity;
import com.example.demo.entity.StateMasterEntity;
import com.example.demo.entity.UserDtlsEntity;
import com.example.demo.repository.CityMasterRepo;
import com.example.demo.repository.CountryMasterRepo;
import com.example.demo.repository.StateMasterRepo;
import com.example.demo.repository.UserDtlsRepo;
import com.example.demo.util.EmailUtils;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {

	@Autowired
	private UserDtlsRepo userDtlsRepo;

	@Autowired
	private StateMasterRepo statesRepo;

	@Autowired
	private CountryMasterRepo countryMasterRepo;

	@Autowired
	private CityMasterRepo cityMasterRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String login(LoginForm loginForm) {
		UserDtlsEntity userDtlsEntity = userDtlsRepo.findByEmailIdAndPassword(loginForm.getEmail(),
				loginForm.getPassword());
		if (userDtlsEntity == null) {
			return "Invalid Credentials";
		}
		if (userDtlsEntity != null && userDtlsEntity.getAccStatus().equals("locked")) {

			return "Your Account Is Locked";
		}
		return "Sucess";
	}

	@Override
	public String emailChecking(String emailId) {
		UserDtlsEntity userDtlsEntity = userDtlsRepo.findByEmailId(emailId);
		if (userDtlsEntity == null) {
			return "UniqueOne";
		}
		return "DuplicateOne";
	}

	@Override
	public Map<Integer, String> countries() {
		List<CountryMasterEntity> list = countryMasterRepo.findAll();

		Map<Integer, String> map = new HashMap<Integer, String>();

		for (CountryMasterEntity entity : list) {
			map.put(entity.getCountryId(), entity.getCountryName());
		}
		return map;
	}

	@Override
	public Map<Integer, String> states(Integer countryId) {
		List<StateMasterEntity> list = statesRepo.findByCountryId(countryId);
		Map<Integer, String> statesmap = new HashMap<Integer, String>();
		for (StateMasterEntity state : list) {
			statesmap.put(state.getCountryId(), state.getStateName());
		}
		return statesmap;
	}

	@Override
	public Map<Integer, String> cities(Integer stateId) {
		List<CityMasterEntity> list = cityMasterRepo.findByStateId(stateId);
		Map<Integer, String> citiesmap = new HashMap<Integer, String>();
		for (CityMasterEntity citys : list) {
			citiesmap.put(citys.getCityId(), citys.getCityName());

		}
		return citiesmap;
	}

	@Override
	public String register(UserRegForm userRegForm) {
		UserDtlsEntity user = new UserDtlsEntity();
		BeanUtils.copyProperties(userRegForm, user);
		user.setAccStatus("Locked");
		user.setPassword(generateRandomPassword());
		UserDtlsEntity entity = userDtlsRepo.save(user);
		String email = userRegForm.getEmailId();
		String subject = "USER REGISTRATION";

		String fileName = "UnlockAccount.txt";
		String body = readMailBody(fileName, user);

		boolean isSent = emailUtils.sendEmail(email, subject, body);
		if (entity.getEmailId() != null && isSent) {
			return "Sucess";
		}
		return "Failure";

	}

	@Override
	public String unlockAccount(UnlockAccForm unlockAccForm) {
		if (!(unlockAccForm.getNewPwd().equals(unlockAccForm.getConfirmNewPwd()))) {
			return "Password and Confirm Password should be same";

		}
		UserDtlsEntity entity = userDtlsRepo.findByEmailIdAndPassword(unlockAccForm.getEmaill(),
				unlockAccForm.getTempPwd());
		if (entity == null) {
			return "Incorrect temp pwd";
		}
		entity.setPassword(unlockAccForm.getNewPwd());
		entity.setAccStatus("UnLocked");
		userDtlsRepo.save(entity);
		return "UNLOCKED ACCOUNT";
	}

	@Override
	public String forgotPassword(String emailId) {
		UserDtlsEntity byEmailId = userDtlsRepo.findByEmailId(emailId);
		if (byEmailId == null) {
			return "INVALID ID";

		}
		String fileName = "RecoveryPassword.txt";
		String body = readMailBody(fileName, byEmailId);
		String subject = "RECOVERY PASSWORD";
		boolean isSent = emailUtils.sendEmail(emailId, subject, body);
		if (isSent) {
			return "password sent to register mail";
		}
		return null;
	}

	public String generateRandomPassword() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}
	private String readMailBody(String fileName, UserDtlsEntity user) {
		String mailBody = null;
		try {
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			mailBody = sb.toString();

			mailBody = mailBody.replace("{FNAME}", user.getFirstName());
			mailBody = mailBody.replace("{LNAME}", user.getLastName());
			mailBody = mailBody.replace("{TEMP-PASSWORD}", user.getTempPwd());
			mailBody = mailBody.replace("{PWD}", user.getPassword());
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mailBody;

	}

}
