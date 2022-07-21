package com.exercise.artist.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exercise.artist.entity.Artist;
import com.exercise.artist.entity.Event;
import com.exercise.artist.entity.Venue;
import com.exercise.artist.exception.APIResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestServiceImpl implements RestService {
	
	public static final String ARTIST_URL = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json";
	public static final String EVENT_URL = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/events.json";
	public static final String VENUE_URL = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/venues.json";
	
	@Autowired
	private RestTemplate restTemplate;
    
	@Override
	// Get all the artists from S3	
    public Artist[] getArtistList() {
        return this.restTemplate.getForObject(ARTIST_URL, Artist[].class);
    }
    
	@Override
	// Get all the events from S3	
    public Event[] getEventsList() {
        return this.restTemplate.getForObject(EVENT_URL, Event[].class);
    }
    
	@Override
	// Get all the venues from S3
    public Venue[] getVenuesList() {
        return this.restTemplate.getForObject(VENUE_URL, Venue[].class);
    }
    
	@Override
	// Get all the events which an artist participates
    public Event[] getArtistEvents( Artist artist ) throws APIResourceNotFoundException
    {
    	Event[]	allEvents = getEventsList();
    	Event[]	eventsOfArtist;
    	// Use map to improve performance
    	Map<String,Venue> allVenuesMap = Arrays.asList(getVenuesList()).stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
    	Map<String,Artist> allArtistMap = Arrays.asList(getArtistList()).stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
    	// Get all the artist's events with basic information from S3
    	eventsOfArtist =  Arrays.stream(allEvents)
    	        .filter(x -> x.getArtists().contains( artist)).toArray(Event[]::new);
    	for( Event e : eventsOfArtist)
    	{
    		if( e.getVenue() == null)
    		{
    			throw new APIResourceNotFoundException("Event has null venue. Event id = " + e.getVenue().getId());
    		}
    		if( e.getArtists() == null)
    		{
    			throw new APIResourceNotFoundException("Event has null artist. Event id = " + e.getVenue().getId());
    		}
    		// Get the detail of event's venue
    		Venue venueOfEvent = allVenuesMap.get(e.getVenue().getId());
    		if( venueOfEvent != null)
    		{
    			e.setVenue(venueOfEvent);
    		}
    		else
    		{
    			throw new APIResourceNotFoundException("Event's venue not found venue id=" + e.getVenue().getId());
    		}
    		// Get the detail of all the artist in event
    		List<Artist> artists = e.getArtists();
    		for( int i= 0; i < artists.size(); i++) 
    		{
    			Artist temp =  allArtistMap.get(artists.get(i).getId());
    			if( temp != null)
        		{
    				artists.set(i, temp);
        		}
        		else
        		{
        			throw new APIResourceNotFoundException("Event's artist not found artist id=" + artists.get(i).getId());
        		}
    		}
    	}
    	return eventsOfArtist;
    }
    
	@Override
    public Artist getArtistById( String artistId ) throws APIResourceNotFoundException
    {
    	Artist[] artistsList = getArtistList();
    	Event[]	eventsOfArtist;
    	Artist artist = Arrays.stream(artistsList)
        .filter(x -> x.getId().equals(artistId))
        .findFirst().orElse(null);
    	if(artist == null)
    	{
    		throw new APIResourceNotFoundException("User not found");
    	}
    	eventsOfArtist = getArtistEvents(artist);
    	artist.setEvents(eventsOfArtist);
    	return artist;
    }
    
    
}
