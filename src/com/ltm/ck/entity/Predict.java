package com.ltm.ck.entity;

import java.util.Date;

public class Predict {
	private int id_predict;
	private String result;
	private Date date_predict;
	private String path_image;
	private int id_user;
	public Predict(String result, Date date_predict, String path_image, int id_user) {
		this.result = result;
		this.date_predict = date_predict;
		this.path_image = path_image;
		this.id_user = id_user;
	}
	public Predict(int id_predict, String result, Date date_predict, String path_image, int id_user) {
		this.id_predict = id_predict;
		this.result = result;
		this.date_predict = date_predict;
		this.path_image = path_image;
		this.id_user = id_user;
	}
	public int getId_predict() {
		return id_predict;
	}
	public void setId_predict(int id_predict) {
		this.id_predict = id_predict;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getDate_predict() {
		return date_predict;
	}
	public void setDate_predict(Date date_predict) {
		this.date_predict = date_predict;
	}
	public String getPath_image() {
		return path_image;
	}
	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
}
