package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParkingRegistration {

	@Id
	private int park_id;

	private String vehicle_number;
	private Date start_date;
	private String parking_start_time;
	private String parking_end_time;
	private String slotBook;
	
	private String user;

	private int park_cost;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPark_id() {
		return park_id;
	}

	public void setPark_id(int park_id) {
		this.park_id = park_id;
	}

	public int getPark_cost() {
		return park_cost;
	}

	public void setPark_cost(int park_cost) {
		this.park_cost = park_cost;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getParking_start_time() {
		return parking_start_time;
	}

	public void setParking_start_time(String parking_start_time) {
		this.parking_start_time = parking_start_time;
	}

	public String getParking_end_time() {
		return parking_end_time;
	}

	public void setParking_end_time(String parking_end_time) {
		this.parking_end_time = parking_end_time;
	}

	public String getSlotBook() {
		return slotBook;
	}

	public void setSlotBook(String slotBook) {
		this.slotBook = slotBook;
	}

	
}