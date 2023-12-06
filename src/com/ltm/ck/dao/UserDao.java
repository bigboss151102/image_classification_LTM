package com.ltm.ck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.ltm.ck.entity.User;

public class UserDao {
	private DataSource dataSource;
	
	public UserDao(DataSource theDataSource) {
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

	public boolean checkLogin(String username, String password) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM user WHERE username=? AND password=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myRs = myStmt.executeQuery();
			if(myRs.next()) {
				return true;
			}
			else {
				return false;
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
	}
	
	public int getIdUser(String username, String password) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int id_user;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT id_user FROM user WHERE username=? AND password=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myRs = myStmt.executeQuery();
			if(myRs.next()) {
				id_user = myRs.getInt(1);
				return id_user;
			}
			else {
				return -1;
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	public void addUser(User theUser) throws SQLException {
		Connection myCnn = null;
		PreparedStatement myStmt = null;
		try {
			myCnn = dataSource.getConnection();
			String sql = "INSERT INTO user"
					+"(username, password, email)"
					+"values(?, ?, ?)";
			
			myStmt = myCnn.prepareStatement(sql);
			
			myStmt.setString(1, theUser.getUsername());
			myStmt.setString(2, theUser.getPassword());
			myStmt.setString(3, theUser.getEmail());
			
			myStmt.execute();
		} finally {
			close(myCnn, myStmt, null);
		}
		
	}		
}
