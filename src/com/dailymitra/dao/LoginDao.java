package com.dailymitra.dao;

public interface LoginDao {
	void create(String email, String password);

	void update(String email, String password, String status);

	void delete(String email);

	boolean check(String email, String password);
}
