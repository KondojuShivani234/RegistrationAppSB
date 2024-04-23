package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="Country_Master")
@Data
public class CountryMasterEntity {
    @Id
    @Column(name="Country_ID")
	private Integer countryId;
    @Column(name = "Country_Name")
	private String countryName;
	@Column(name="Country_Code")
	private String countrycode;	
	
}
