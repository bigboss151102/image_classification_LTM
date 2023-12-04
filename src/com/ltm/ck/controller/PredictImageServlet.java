package com.ltm.ck.controller;

import java.io.BufferedReader;

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

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
		
		
//		Part imagePart = request.getPart("imagefile");
//		String imageFileName = imagePart.getSubmittedFileName();
//		
//		String uploadPath = "C:/Java/LTM_CK/WebContent/images/"+imageFileName;
//		
//        try {
//			FileOutputStream fos = new FileOutputStream(uploadPath);
//			InputStream is = imagePart.getInputStream();
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			fos.write(data);
//			fos.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        try {
//            // Tạo URL của Flask API
//            URL url = new URL("http://127.0.0.1:3000/predict");
//
//            // Mở kết nối HTTP
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            // Thiết lập phương thức POST và thiết lập đặc điểm của kết nối
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "image/png"); // Đặt loại nội dung cho ảnh JPEG hoặc thay đổi tùy thuộc vào loại ảnh bạn sử dụng
//            connection.setDoOutput(true);
//
//            // Đọc dữ liệu ảnh từ file (hoặc từ InputStream nếu bạn có nó từ nguồn khác)
//            Path imagePath = Paths.get(uploadPath); // Đặt đường dẫn đến file ảnh của bạn
//            byte[] imageBytes = Files.readAllBytes(imagePath);
//
//            // Gửi dữ liệu ảnh đến Flask API
//            try (OutputStream os = connection.getOutputStream()) {
//                os.write(imageBytes);
//            }
//
//            // Đọc phản hồi từ Flask API (nếu cần)
//            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
//                StringBuilder responseBuilder = new StringBuilder();
//                String responseLine;
//                while ((responseLine = br.readLine()) != null) {
//                    responseBuilder.append(responseLine.trim());
//                }
//                System.out.println("Response from Flask API: " + responseBuilder.toString());
                

                
//                String json_response = responseBuilder.toString();
//                JSONObject jsonObject = new JSONObject(json_response);
//                
//                String imageClass = jsonObject.getString("class");
//                Double confidence = jsonObject.getDouble("confidence");
//                
//                System.out.println(imageClass);
//                System.out.println(confidence);
                
//                String list_page = "result.jsp";
//                String result = responseBuilder.toString();
//                request.getSession().setAttribute("result", result);
//                RequestDispatcher dispatcher = request.getRequestDispatcher(list_page);
//                dispatcher.forward(request, response);
//            }
//            connection.disconnect();
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
    }
}
