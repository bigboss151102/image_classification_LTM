package com.ltm.ck.entity;

import java.util.Date;

public class Image {
	private int id_image;
	private String name_image;
    private byte[] value_image;
    private Date date_post;
    private int id_user;
    
	public Image(String name_image, byte[] value_image, Date date_post, int id_user) {
		this.name_image = name_image;
		this.value_image = value_image;
		this.date_post = date_post;
		this.id_user = id_user;
	}

	public Image(int id_image, String name_image, byte[] value_image, Date date_post, int id_user) {
		super();
		this.id_image = id_image;
		this.name_image = name_image;
		this.value_image = value_image;
		this.date_post = date_post;
		this.id_user = id_user;
	}

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}

	public String getName_image() {
		return name_image;
	}

	public void setName_image(String name_image) {
		this.name_image = name_image;
	}

	public byte[] getValue_image() {
		return value_image;
	}

	public void setValue_image(byte[] value_image) {
		this.value_image = value_image;
	}

	public Date getDate_post() {
		return date_post;
	}

	public void setDate_post(Date date_post) {
		this.date_post = date_post;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
    
	
    
}
