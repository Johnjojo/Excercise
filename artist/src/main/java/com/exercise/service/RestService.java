package com.exercise.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exercise.entity.Artist;
import com.exercise.entity.Event;
import com.exercise.entity.Venue;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestService {
	
	public static final String ARTIST_URL = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json";
	public static final String EVENT_URL = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json";
	public static final String VENUE_URL = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json";
	
	private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public Map<Artist> getArtistAsObject() {
    	String json = restTemplate.getForObject(ARTIST_URL, String.class);
    	Map<String,String> map = new HashMap<String,String>();
    	ObjectMapper mapper = new ObjectMapper();

    	try {
    	    //convert JSON string to Map
    	   map = mapper.readValue(json, new TypeReference<HashMap<String,String>>(){});
    	} catch (Exception e) {
    	     logger.info("Exception converting {} to map", json, e);
    	}

    	return map;
    	
    }
    
    public Event[] getEventAsObject() {
        return this.restTemplate.getForObject(EVENT_URL, Event[].class);
    }
    
    public Venue[] getVenueAsObject() {
        return this.restTemplate.getForObject(VENUE_URL, Venue[].class);
    }
    
}
