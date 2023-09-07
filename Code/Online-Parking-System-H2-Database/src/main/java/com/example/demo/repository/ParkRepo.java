package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ParkingRegistration;

public interface ParkRepo extends CrudRepository<ParkingRegistration, Integer>{

	public ParkingRegistration findBySlotBook(String slotBook);
	
	public List<ParkingRegistration> findByUser(String user);
	
	List<ParkingRegistration> findAll();
}
