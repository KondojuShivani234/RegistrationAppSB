package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "User_Accounts")
@Data
public class UserDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name = "User_ID")
	private Integer userid;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "User_Email", unique = true)
	private String emailId;
	
	@Column(name = "User_Pwd")
	private String password;
	
	@Column(name = "User_Phno")
	private long phno;
	
	@Column(name = "DOB")
	
	private LocalDate dob;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "City_ID")
	private Integer cityId;
	
	@Column(name = "State_ID")
	private Integer stateId;
	
	@Column(name = "Country_ID")
	private Integer countryId;
	
	@Column(name = "Temp_PWD")
	private String tempPwd;
	
	@Column(name = "Acc_Status")
	private String accStatus;
	
	@Column(name = "Created_Date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "Upadated_Date", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
}
