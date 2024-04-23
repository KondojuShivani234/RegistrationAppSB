package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Citys_Master")
@Data
public class CityMasterEntity {
	@Id
	@GeneratedValue
	@Column(name = "City_ID")
	private Integer cityId;
	@Column(name = "City_Name")
	private String cityName;
	@Column(name = "State_ID")
	private Integer stateId;

}
