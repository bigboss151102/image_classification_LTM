package com.ltm.ck.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import org.json.JSONObject;

import com.ltm.ck.dao.PredictDao;
import com.ltm.ck.dao.UserDao;
import com.ltm.ck.entity.Predict;

public class PredictService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private PredictDao predictDao;
	private UserDao userDao;

	public PredictService(HttpServletRequest request, HttpServletResponse response, DataSource theDataSource) {
		super();
		this.request = request;
		this.response = response;
		this.predictDao = new PredictDao(theDataSource);
	}

	public void predict() throws IOException, ServletException {
		Part imagePart = request.getPart("imagefile");
		String imageFileName = imagePart.getSubmittedFileName();
		String uploadPath = "C:/Java/LTM_CK/WebContent/images/"+imageFileName;

        try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = imagePart.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
            URL url = new URL("http://127.0.0.1:3000/predict");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "image/png");
            connection.setDoOutput(true);

            Path imagePath = Paths.get(uploadPath);
            byte[] imageBytes = Files.readAllBytes(imagePath);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(imageBytes);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder responseBuilder = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    responseBuilder.append(responseLine.trim());
                }
                String jsonResponse = responseBuilder.toString();
                System.out.println("Response from Flask API: " + jsonResponse);
                
                JSONObject json = new JSONObject(jsonResponse);

                // Lấy giá trị của class và confidence từ JSONObject
                String imageClass = json.getString("class");
                double confidence = json.getDouble("confidence");
                
                System.out.println("Class: " + imageClass);
                System.out.println("Confidence: " + confidence);
                
                int user_id = (int) request.getSession().getAttribute("id_user");
                
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date date_predict = new Date(utilDate.getTime());
                
                Predict predict = new Predict(imageClass, confidence, date_predict, uploadPath, imageBytes, user_id);
                predictDao.SavePredict(predict);
                
		        request.getSession().setAttribute("imageClass", imageClass);
		        request.getSession().setAttribute("confidence", confidence);
		   
		        String list_page = "predict.jsp";
		        RequestDispatcher dispatcher = request.getRequestDispatcher(list_page);
		        dispatcher.forward(request, response);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	
}
