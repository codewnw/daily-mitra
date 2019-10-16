package com.dailymitra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.dailymitra.dao.util.DbUtil;
import com.dailymitra.model.Address;
import com.dailymitra.model.Customer;

public class AddressDaoImpl implements AddressDao {

	@Override
	public void create(Address address) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO DAILYMITRA_ADDRESS VALUES(?, ?, ?, ?, ?, ?)")) {
			pstmt.setString(1, address.getEmail());
			pstmt.setString(2, address.getAddress1());
			pstmt.setString(3, address.getAddress2());
			pstmt.setString(4, address.getCity());
			pstmt.setString(5, address.getState());
			pstmt.setString(6, address.getPin());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Address customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public Address read(String email) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DAILYMITRA_ADDRESS WHERE EMAIL = ?")) {

			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Address address = new Address();
				address.setEmail(rs.getString("EMAIL"));
				address.setAddress1(rs.getString("ADDRESS1"));
				address.setAddress2(rs.getString("ADDRESS2"));
				address.setCity(rs.getString("CITY"));
				address.setState(rs.getString("STATE"));
				address.setPin(rs.getString("PIN"));
				return address;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("CREATE TABLE " + DbConstant.ADDRESS_TABLE
					+ "(EMAIL VARCHAR(200) PRIMARY KEY, ADDRESS1 VARCHAR(50), ADDRESS2 VARCHAR(50), CITY VARCHAR(50), STATE VARCHAR(50), PIN VARCHAR(50))");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("DROP TABLE " + DbConstant.ADDRESS_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createBaseData() {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO DAILYMITRA_ADDRESS VALUES(?, ?, ?, ?, ?, ?)")) {

			pstmt.setString(1, "r@s.com");
			pstmt.setString(2, "#100");
			pstmt.setString(3, "Rajiv Chowk");
			pstmt.setString(4, "New Delhi");
			pstmt.setString(5, "Delhi");
			pstmt.setString(6, "100001");
			pstmt.addBatch();

			pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
