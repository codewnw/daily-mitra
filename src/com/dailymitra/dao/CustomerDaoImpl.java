package com.dailymitra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

	@Override
	public void createTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("CREATE TABLE " + DbConstant.CUSTOMER_TABLE + "(NAME VARCHAR(200), EMAIL VARCHAR(200))");
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
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DAILYMITRA_CUSTOMER VALUES(?, ?)")) {

			pstmt.setString(1, "Admin");
			pstmt.setString(2, "admin@admin.com");
			pstmt.addBatch();

			pstmt.setString(1, "Rohit");
			pstmt.setString(2, "r@s.com");
			pstmt.addBatch();

			pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
