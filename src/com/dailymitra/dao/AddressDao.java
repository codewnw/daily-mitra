package com.dailymitra.dao;

import java.util.List;

import com.dailymitra.model.Address;

public interface AddressDao {
	void createTable();

	void create(Address customer);

	void update(Address customer);

	void delete(String email);

	Address read(String email);

	List<Address> readAll();

	void dropTable();

	void createBaseData();
}
