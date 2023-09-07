package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserRegistration;

public interface UserRepo extends CrudRepository<UserRegistration, String>{

	public UserRegistration findByEmailAndPassword(String email,String password);
	
	List<UserRegistration> findAll();
	

}
