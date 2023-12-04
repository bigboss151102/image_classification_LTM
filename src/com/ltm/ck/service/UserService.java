package com.ltm.ck.service; 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ltm.ck.dao.UserDao;

public class UserService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private UserDao userDao;
	
	public UserService(HttpServletRequest request, HttpServletResponse response, DataSource theDataSource) {
		super();
		this.request = request;
		this.response = response;
		this.userDao = new UserDao(theDataSource);
	}

	public void checkLogin() throws ServletException, IOException, SQLException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean loginResult = userDao.checkLogin(username, password);
		
		if(loginResult) {
			request.getSession().setAttribute("username", username);
			String page_predict = "predict.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(page_predict);
			dispatcher.forward(request, response);
		}else {
			String message = "Đăng nhập thất bại. Vui lòng thử lại !";
			request.setAttribute("message", message);
			String page_login = "login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(page_login);
			dispatcher.forward(request, response);
		}
	}
		
}
