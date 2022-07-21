package com.exercise.artist.entity;

import java.io.Serializable;


public class Venue implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	String name;
	String url;
	String city;
	String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
