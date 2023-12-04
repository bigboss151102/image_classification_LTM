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
		int id_user = userDao.getIdUser(username, password);
		System.out.println(id_user);
		if(loginResult) {
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("id_user", id_user);
			String page_predict = "predict.jsp";
			String page_list = "list.jsp";
			RequestDispatcher dispatcher_predict = request.getRequestDispatcher(page_predict);
			RequestDispatcher dispatcher_list = request.getRequestDispatcher(page_list);
			dispatcher_predict.forward(request, response);
			dispatcher_list.forward(request, response);
		}else {
			String message = "Đăng nhập thất bại. Vui lòng thử lại !";
			request.setAttribute("message", message);
			String page_login = "login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(page_login);
			dispatcher.forward(request, response);
		}
	}
		
}
