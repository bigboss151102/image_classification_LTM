package com.ltm.ck.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import javax.sql.DataSource;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.ByteArrayBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import com.ltm.ck.entity.Predict;

public class PredictDao {
	private DataSource dataSource;
	
	public PredictDao(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void SavePredict(Predict predict) throws SQLException {
		Connection myCnn = null;
		PreparedStatement myStmt = null;
		try {
			myCnn = dataSource.getConnection();
			String sql = "INSERT INTO predict"
					+"(result, rate_predict, image, path_image, date_predict, id_user)"
					+"values(?, ?, ?, ?, ?, ?)";
			
			myStmt = myCnn.prepareStatement(sql);
			myStmt.setString(1, predict.getResult());
			myStmt.setDouble(2, predict.getRate_predict());
			myStmt.setBytes(3, predict.getImage());
			myStmt.setString(4, predict.getPath_image());
			myStmt.setDate(5,predict.getDate_predict());
			myStmt.setInt(6, predict.getId_user());
			myStmt.execute();
		} finally {
			close(myCnn, myStmt, null);
		}
	}

	public List<Predict> getAllPredict() throws SQLException {
		List<Predict> predicts = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM predict ORDER BY date_predict";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				int id_predict = myRs.getInt("id_predict");
				int id_user = myRs.getInt("id_user");
				String result = myRs.getString("result");
				Double rate_predict = myRs.getDouble("rate_predict");
				byte[] image = myRs.getBytes("image");
				String path_image = myRs.getString("path_image");
				Date date_predict = myRs.getDate("date_predict");
				
				Predict tempPredict = new Predict(id_predict, result, rate_predict, date_predict, path_image, image, id_user);
				
				predicts.add(tempPredict);
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
		
		return predicts;
	}

	public void deletePredict(Integer predict_id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "DELETE  FROM predict WHERE id_predict=?";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, predict_id);
			
			myStmt.execute();
			
		} finally {
			close(myConn, myStmt, null);
		}
	}
	
	public int countPredict() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		int count_predict = 0;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT COUNT(*) AS count FROM predict";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				count_predict = myRs.getInt("count");
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
		return count_predict;
	}
	
	public List<Predict> pagingPredict(Integer index) throws SQLException{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Predict> predicts = new ArrayList<>();

		try {
			myConn = dataSource.getConnection();
			
			String sql = "SELECT * FROM predict ORDER BY id_predict LIMIT 3 OFFSET ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, (index-1)*3);
			myRs = myStmt.executeQuery();
			while(myRs.next()) {
				int id_predict = myRs.getInt("id_predict");
				int id_user = myRs.getInt("id_user");
				String result = myRs.getString("result");
				Double rate_predict = myRs.getDouble("rate_predict");
				byte[] image = myRs.getBytes("image");
				String path_image = myRs.getString("path_image");
				Date date_predict = myRs.getDate("date_predict");
				
				Predict tempPredict = new Predict(id_predict, result, rate_predict, date_predict, path_image, image, id_user);
				
				predicts.add(tempPredict);
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
		return predicts;
	}

	public List<Predict> getAllPredict(int user_id) throws SQLException {
		List<Predict> predicts = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM predict WHERE id_user=? ORDER BY date_predict";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, user_id);
			myRs = myStmt.executeQuery();
			while(myRs.next()) {
				int id_predict = myRs.getInt("id_predict");
				int id_user = myRs.getInt("id_user");
				String result = myRs.getString("result");
				Double rate_predict = myRs.getDouble("rate_predict");
				byte[] image = myRs.getBytes("image");
				String path_image = myRs.getString("path_image");
				Date date_predict = myRs.getDate("date_predict");
				
				Predict tempPredict = new Predict(id_predict, result, rate_predict, date_predict, path_image, image, id_user);
				
				predicts.add(tempPredict);
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
		
		return predicts;
	}
}
