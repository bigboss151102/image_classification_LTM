package com.ltm.ck.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ltm.ck.dao.UserDao;
import com.ltm.ck.service.UserService;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	@Resource(name="jdbc/ltm_ck")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			userDao = new UserDao(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService(request, response, dataSource);
		try {
			userService.registerUser();
		} catch (IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
