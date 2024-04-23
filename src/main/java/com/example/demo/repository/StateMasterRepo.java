package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StateMasterEntity;

public interface StateMasterRepo extends JpaRepository<StateMasterEntity, Integer>{
	public List<StateMasterEntity> findByCountryId(Integer countryId);
}
