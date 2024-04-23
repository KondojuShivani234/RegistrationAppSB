package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="States_Master")
@Data
public class StateMasterEntity {
	@Id
	@Column(name="State_ID")
private Integer stateId;
	@Column(name="State_Name")
private String stateName;
	@Column(name="Country_ID")
private Integer countryId;

}
