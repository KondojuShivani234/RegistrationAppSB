package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserDtlsEntity;
@Repository
public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer> {

	
	public UserDtlsEntity findByEmailIdAndPassword(String email,String password);
	
	public UserDtlsEntity findByEmailId(String emailId);
	
}
