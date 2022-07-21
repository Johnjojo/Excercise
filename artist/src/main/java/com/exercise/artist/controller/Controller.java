package com.exercise.artist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.artist.entity.Artist;
import com.exercise.artist.service.RestServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	RestServiceImpl restService;

	@GetMapping(path = "/artist/{id}", produces = "application/json")
	 public @ResponseBody Artist process(@PathVariable("id") String id) throws Exception{
		
		return restService.getArtistById(id);
	  }
}
