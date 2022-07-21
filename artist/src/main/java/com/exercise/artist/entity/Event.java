package com.exercise.artist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("title")
	String title;
	@JsonProperty("dateStatus")
	String dateStatus;
	@JsonProperty("id")
	String id;
	@JsonProperty("timeZone")
	String timeZone;
	@JsonProperty("startDate")
	Date startDate;
	@JsonProperty("artists")
	List<Artist> artists;
	@JsonProperty("hiddenFromSearch")
	boolean hiddenFromSearch;
	@JsonProperty("venue")
	Venue venue;
	
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
	
	public List<Artist> getArtists() {
		return artists;
	}
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	public boolean isHiddenFromSearch() {
		return hiddenFromSearch;
	}
	public void setHiddenFromSearch(boolean hiddenFromSearch) {
		this.hiddenFromSearch = hiddenFromSearch;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	
	
	
}
