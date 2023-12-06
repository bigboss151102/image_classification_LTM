package com.ltm.ck.controller;

import java.io.IOException;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import com.ltm.ck.dao.PredictDao;
import com.ltm.ck.service.PredictService;


@WebServlet("/PredictImageServlet")
@MultipartConfig
public class PredictImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PredictDao predictDao;
	
	@Resource(name="jdbc/ltm_ck")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			predictDao = new PredictDao(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PredictService predictService = new PredictService(request, response, dataSource);
		predictService.predict();
    }
}
