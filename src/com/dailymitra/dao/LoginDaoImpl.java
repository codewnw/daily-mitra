package com.dailymitra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dailymitra.dao.util.DbUtil;

public class LoginDaoImpl implements LoginDao {

	public void create(String email, String password) {
		// TODO Auto-generated method stub

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

}
