package com.exercise.artist.service;

import com.exercise.artist.entity.Artist;
import com.exercise.artist.entity.Event;
import com.exercise.artist.entity.Venue;
import com.exercise.artist.exception.APIResourceNotFoundException;

public interface RestService {
	 public Artist[] getArtistList();
	 public Event[] getEventsList();
	 public Venue[] getVenuesList();
	 public Event[] getArtistEvents( Artist artist ) throws APIResourceNotFoundException;
	 public Artist getArtistById( String artistId ) throws APIResourceNotFoundException;
	 
}
