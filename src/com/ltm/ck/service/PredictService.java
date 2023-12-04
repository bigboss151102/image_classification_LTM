package com.ltm.ck.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.ltm.ck.dao.PredictDao;

public class PredictService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private PredictDao predictDao;

	public PredictService(HttpServletRequest request, HttpServletResponse response, DataSource theDataSource) {
		super();
		this.request = request;
		this.response = response;
		this.predictDao = new PredictDao(theDataSource);
	}

}
