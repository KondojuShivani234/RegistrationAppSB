package com.example.demo.bindings;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserRegForm {
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String password;
	
	private long phno;
	
	private LocalDate dob;
	
	private String gender;
	
	private Integer cityId;
	
	private Integer stateId;
	
	private Integer countryId;
	
	private String accStatus;
	

}
