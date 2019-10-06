package com.dailymitra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dailymitra.dao.util.DbUtil;
import com.dailymitra.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void create(Customer customer) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DAILYMITRA_CUSTOMER VALUES(?, ?)")) {
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.executeUpdate();
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

}
