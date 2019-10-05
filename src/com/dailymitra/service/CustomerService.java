package com.dailymitra.service;

import java.util.List;

import com.dailymitra.model.Customer;

public interface CustomerService {

	void create(Customer customer);
	
	void update(Customer customer);
	
	void delete(String email);
	
	Customer read(String email);
	
	List<Customer> readAll();
}
