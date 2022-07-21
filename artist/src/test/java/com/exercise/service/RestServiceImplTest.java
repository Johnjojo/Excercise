package com.exercise.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.web.client.RestTemplate;

import com.exercise.artist.entity.Artist;
import com.exercise.artist.entity.Event;
import com.exercise.artist.entity.Venue;
import com.exercise.artist.exception.APIResourceNotFoundException;
import com.exercise.artist.service.RestServiceImpl;

class RestServiceImplTest {

	@Spy
	RestTemplate restTemplate = new RestTemplate();

	@InjectMocks
	RestServiceImpl restService = new RestServiceImpl();

	@BeforeEach
	private void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetArtistList() {
		Artist[] allArtist = restService.getArtistList();
		assertNotNull(allArtist);
		assertTrue(allArtist.length > 0);
		Artist artist = allArtist[0];
		assertNotNull(artist.getId());
		assertNotNull(artist.getName());
	}

	  @Test void testGetEventList() { 
		  Event[] allEvents = restService.getEventsList(); 
		  assertNotNull(allEvents);
		  assertTrue(allEvents.length > 0 ); 
		  Event event = allEvents[0]; assertNotNull(
		  event.getArtists() ); 
		  assertTrue( event.getArtists().size() > 0);
		  assertNotNull( event.getVenue() );
	  }

	@Test
	void testGetVenueList() {
		Venue[] allVenues = restService.getVenuesList();
		assertNotNull(allVenues);
		assertTrue(allVenues.length > 0);
		Venue venue = allVenues[0];
		assertNotNull(venue.getId());
		assertNotNull(venue.getName());
		assertNotNull(venue.getCity());
	}


	 @Test void testGetArtistEvents(){ 
		 String lookupId = "21"; 
		 try { 
			 Artist artist = new Artist();
			 artist.setId(lookupId);
			 Event[] eventsOfArtistEvents 
			 	= restService.getArtistEvents(artist); 
			 Event event;
			 assertNotNull(eventsOfArtistEvents); 
			 assertTrue(eventsOfArtistEvents.length > 0); 
			 event = eventsOfArtistEvents[0]; 
			 assertNotNull( event ); 
			 assertNotNull( event.getVenue() ); 
			 assertTrue( event.getArtists().stream().filter(x ->
			 	x.equals(artist)).count() == 1);
	
	  } catch (Exception e) { fail(e.getMessage()); } }

	@Test
	void testGetArtistById() {
		try {
			String lookupId = "21";
			Artist artist = restService.getArtistById(lookupId);
			assertNotNull(artist);
			assertTrue(artist.getId().equals(lookupId));
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	void exceptionTesting() {
		String lookupId = "-999";
		APIResourceNotFoundException thrown = assertThrows(
				APIResourceNotFoundException.class,
				() ->  restService.getArtistById(lookupId),
		           "Expected doThing() to throw, but it didn't"
		    );
	    assertTrue(thrown.getMessage().contains("not found"));
	}
	

}
