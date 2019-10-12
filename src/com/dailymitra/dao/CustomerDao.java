package com.dailymitra.dao;

import java.util.List;

import com.dailymitra.model.Customer;

public interface CustomerDao {
	void createTable();
	
	void create(Customer customer);

	void update(Customer customer);

	void delete(String email);

	Customer read(String email);

	List<Customer> readAll();
	
	void dropTable();
	
	void createBaseData();
}
