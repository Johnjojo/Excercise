package com.exercise.entity;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
	
	String title;
	String dateStatus;
	String id;
	String timeZone;
	Date startDate;
	String[] artists;
	String venueId;
	boolean hiddenFromSearch;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateStatus() {
		return dateStatus;
	}
	public void setDateStatus(String dateStatus) {
		this.dateStatus = dateStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String[] getArtists() {
		return artists;
	}
	public void setArtists(String[] artists) {
		this.artists = artists;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public boolean isHiddenFromSearch() {
		return hiddenFromSearch;
	}
	public void setHiddenFromSearch(boolean hiddenFromSearch) {
		this.hiddenFromSearch = hiddenFromSearch;
	}
	
	
	
	
}
