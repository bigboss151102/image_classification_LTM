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

}
