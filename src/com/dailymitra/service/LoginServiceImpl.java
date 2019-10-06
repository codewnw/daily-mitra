package com.dailymitra.service;

import com.dailymitra.dao.LoginDao;
import com.dailymitra.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;

	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public void create(String email, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String email, String password, String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean check(String email, String password) {
		return loginDao.check(email, password);
	}

}
