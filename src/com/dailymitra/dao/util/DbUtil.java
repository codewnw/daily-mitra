package com.dailymitra.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static Connection connection;

	public static Connection getCon() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		}
		return connection;
	}
}
