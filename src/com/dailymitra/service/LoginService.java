package com.dailymitra.service;

public interface LoginService {
	void create(String email, String password);

	void update(String email, String password, String status);

	void delete(String email);

	boolean check(String email, String password);
}
