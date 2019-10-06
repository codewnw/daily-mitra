package com.dailymitra.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailymitra.model.Customer;
import com.dailymitra.service.CustomerService;
import com.dailymitra.service.CustomerServiceImpl;
import com.dailymitra.service.LoginService;
import com.dailymitra.service.LoginServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;

	private CustomerService customerService;

	public LoginServlet() {
		loginService = new LoginServiceImpl();
		customerService = new CustomerServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPattern = request.getRequestURI();
		System.out.println(urlPattern);
		if (urlPattern.contains("login")) {
			response.sendRedirect("login.jsp");
		} else if (urlPattern.contains("logout")) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean isValidUser = loginService.check(email, password);
		if (isValidUser) {
			HttpSession session = request.getSession();
			Customer customer = customerService.read(email);
			session.setAttribute("customer", customer);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp?message=Login failed. Please try again...");
		}

	}

}
