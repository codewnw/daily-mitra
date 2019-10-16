package com.dailymitra.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailymitra.model.Address;
import com.dailymitra.model.Customer;
import com.dailymitra.service.CustomerService;
import com.dailymitra.service.CustomerServiceImpl;
import com.dailymitra.service.LoginService;
import com.dailymitra.service.LoginServiceImpl;

@WebServlet(description = "Registration Servlet", urlPatterns = { "/register" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService;

	private LoginService loginService;

	public RegistrationServlet() {
		customerService = new CustomerServiceImpl();
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("registration.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pin = request.getParameter("pin");
		

		Address address = new Address();
		address.setEmail(email);
		address.setAddress1(address1);
		address.setAddress2(address2);
		address.setCity(city);
		address.setState(state);
		address.setPin(pin);
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setAddress(address);

		customerService.create(customer);
		loginService.create(email, password);

		response.sendRedirect("index.jsp?message=Signup successfull. Please Login.");
	}

}
