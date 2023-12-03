package com.ltm.ck.entity;

import java.util.Date;

public class Predict {
	private int id_predict;
	private String result;
	private Date date_predict;
	private int id_image;
	
	public Predict(String result, Date date_predict, int id_image) {
		this.result = result;
		this.date_predict = date_predict;
		this.id_image = id_image;
	}

	public Predict(int id_predict, String result, Date date_predict, int id_image) {
		this.id_predict = id_predict;
		this.result = result;
		this.date_predict = date_predict;
		this.id_image = id_image;
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

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}
	
	
	
	
	
	
}
