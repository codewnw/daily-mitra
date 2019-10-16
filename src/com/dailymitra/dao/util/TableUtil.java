package com.dailymitra.dao.util;

import java.util.HashMap;
import java.util.Map;

import com.dailymitra.dao.AddressDao;
import com.dailymitra.dao.AddressDaoImpl;
import com.dailymitra.dao.CustomerDao;
import com.dailymitra.dao.CustomerDaoImpl;
import com.dailymitra.dao.DbConstant;
import com.dailymitra.dao.LoginDao;
import com.dailymitra.dao.LoginDaoImpl;

public class TableUtil {

	private LoginDao loginDao;

	private CustomerDao customerDao;

	private AddressDao addressDao;

	private DataBaseMetaDetaUtil dataBaseMetaDetaUtil;

	private Map<String, Boolean> tablesToBeCreated = new HashMap<>();

	public TableUtil() {
		loginDao = new LoginDaoImpl();
		customerDao = new CustomerDaoImpl();
		addressDao = new AddressDaoImpl();
		dataBaseMetaDetaUtil = new DataBaseMetaDetaUtil();
		tablesToBeCreated.put(DbConstant.LOGIN_TABLE, true);
		tablesToBeCreated.put(DbConstant.CUSTOMER_TABLE, true);
		tablesToBeCreated.put(DbConstant.ADDRESS_TABLE, true);
	}

	public void createTables() {
		dataBaseMetaDetaUtil.identifyAndMarkNewTables(tablesToBeCreated);

		if (tablesToBeCreated.get(DbConstant.LOGIN_TABLE)) {
			System.out.println("Creating table: " + DbConstant.LOGIN_TABLE);
			loginDao.createTable();
		}

		if (tablesToBeCreated.get(DbConstant.CUSTOMER_TABLE)) {
			System.out.println("Creating table: " + DbConstant.CUSTOMER_TABLE);
			customerDao.createTable();
		}

		if (tablesToBeCreated.get(DbConstant.ADDRESS_TABLE)) {
			System.out.println("Creating table: " + DbConstant.ADDRESS_TABLE);
			addressDao.createTable();
		}
	}

	public void dropTables() {
		loginDao.dropTable();
		customerDao.dropTable();
		addressDao.dropTable();
	}

	public void createBaseData() {
		loginDao.createBaseData();
		customerDao.createBaseData();
		addressDao.createBaseData();
	}
}
