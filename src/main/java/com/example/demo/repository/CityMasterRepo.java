package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CityMasterEntity;

public interface CityMasterRepo extends JpaRepository<CityMasterEntity,Integer>{
public List<CityMasterEntity> findByStateId(Integer stateId);
}
