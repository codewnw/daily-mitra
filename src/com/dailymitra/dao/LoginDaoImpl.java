package com.dailymitra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dailymitra.dao.util.DbUtil;

public class LoginDaoImpl implements LoginDao {

	public void create(String email, String password) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DAILYMITRA_LOGIN VALUES(?, ?, ?)")) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, "Not Verified");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String email, String password, String status) {
		// TODO Auto-generated method stub

	}

	public void delete(String email) {
		// TODO Auto-generated method stub

	}

	public boolean check(String email, String password) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM DAILYMITRA_LOGIN WHERE EMAIL = ? AND PASSWORD = ?")) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void createTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("CREATE TABLE " + DbConstant.LOGIN_TABLE
					+ "(EMAIL VARCHAR(200) PRIMARY KEY, PASSWORD VARCHAR(200), STATUS VARCHAR(50))");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropTable() {
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			stmt.execute("DROP TABLE " + DbConstant.LOGIN_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createBaseData() {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DAILYMITRA_LOGIN VALUES(?, ?, ?)")) {

			pstmt.setString(1, "admin@admin.com");
			pstmt.setString(2, "admin");
			pstmt.setString(3, "Admin");
			pstmt.addBatch();

			pstmt.setString(1, "r@s.com");
			pstmt.setString(2, "rohit");
			pstmt.setString(3, "Verified");
			pstmt.addBatch();

			pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
