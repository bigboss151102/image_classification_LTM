package com.ltm.ck.entity;

import java.beans.Transient;
import java.util.Base64;
import java.sql.Date;

public class Predict {
	private int id_predict;
	private String result;
	private Double rate_predict;
	private Date date_predict;
	private String path_image;
	private byte[] image;
	private String base64Image;
	private int id_user;
	
	public Predict(String result, Double rate_predict, Date date_predict, String path_image, byte[] image, int id_user) {
		this.result = result;
		this.rate_predict = rate_predict;
		this.date_predict = date_predict;
		this.path_image = path_image;
		this.image = image;
		this.id_user = id_user;
	}

	public Predict(int id_predict, String result,Double rate_predict, Date date_predict, String path_image, byte[] image, int id_user) {
		this.id_predict = id_predict;
		this.result = result;
		this.date_predict = date_predict;
		this.rate_predict = rate_predict;
		this.path_image = path_image;
		this.image = image;
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
	
	public Double getRate_predict() {
		return rate_predict;
	}
	
	public void setRate_predict(Double rate_predict) {
		this.rate_predict = rate_predict;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	
	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
}
