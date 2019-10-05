package com.dailymitra.service;

import java.util.List;

import com.dailymitra.dao.CustomerDao;
import com.dailymitra.dao.CustomerDaoImpl;
import com.dailymitra.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		this.customerDao = new CustomerDaoImpl();
	}

	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer read(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
