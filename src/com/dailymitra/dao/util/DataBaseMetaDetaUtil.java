package com.dailymitra.dao.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBaseMetaDetaUtil {

	private List<String> getAllTable() {
		List<String> tables = new ArrayList<>();
		try (Connection con = DbUtil.getCon();) {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getTables(null, null, "DAILYMITRA_%", null);
			while (rs.next()) {
				tables.add(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

	public void identifyAndMarkNewTables(Map<String, Boolean> map) {
		getAllTable().forEach(table -> {
			if (map.containsKey(table)) {
				map.put(table, false);
			}
		});
	}
}
