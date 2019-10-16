package com.dailymitra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.dailymitra.dao.util.DbUtil;
import com.dailymitra.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private AddressDao addressDao;
	
	

	public CustomerDaoImpl() {
		addressDao = new AddressDaoImpl();
	}

	@Override
	public void create(Customer customer) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DAILYMITRA_CUSTOMER VALUES(?, ?, ?)")) {
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getMobile());
			pstmt.executeUpdate();
			addressDao.create(customer.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DAILYMITRA_CUSTOMER WHERE EMAIL = ?")) {

			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString("NAME"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setMobile(rs.getString("MOBILE"));
				customer.setAddress(addressDao.read(email));
				return customer;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("CREATE TABLE " + DbConstant.CUSTOMER_TABLE + "(NAME VARCHAR(200), EMAIL VARCHAR(200) PRIMARY KEY, MOBILE VARCHAR(50))");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("DROP TABLE " + DbConstant.CUSTOMER_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createBaseData() {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DAILYMITRA_CUSTOMER VALUES(?, ?, ?)")) {

			pstmt.setString(1, "Admin");
			pstmt.setString(2, "admin@admin.com");
			pstmt.setString(3, "9876543210");
			pstmt.addBatch();

			pstmt.setString(1, "Rohit");
			pstmt.setString(2, "r@s.com");
			pstmt.setString(3, "9876543210");
			pstmt.addBatch();

			pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
