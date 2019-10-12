package com.dailymitra.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dailymitra.dao.util.TableUtil;

@WebListener
public class ApplicationListener implements ServletContextListener {

	private TableUtil tableUtil;

	public ApplicationListener() {
		tableUtil = new TableUtil();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application is up");
		
		String dropTable = sce.getServletContext().getInitParameter("dropTable");
		if (dropTable.equalsIgnoreCase("Yes")) {
			System.out.println("Table drop is required.");
			tableUtil.dropTables();
		} else {
			System.out.println("Table drop is not required.");
		}
		
		String createTable = sce.getServletContext().getInitParameter("createTable");
		if (createTable.equalsIgnoreCase("Yes")) {
			System.out.println("Table creation is required.");
			tableUtil.createTables();
		} else {
			System.out.println("Table creation is not required.");
		}
		
		String createBaseData = sce.getServletContext().getInitParameter("createBaseData");
		if (createBaseData.equalsIgnoreCase("Yes")) {
			System.out.println("BaseData creation is required.");
			tableUtil.createBaseData();
		} else {
			System.out.println("BaseData creation is not required.");
		}
	}

}
