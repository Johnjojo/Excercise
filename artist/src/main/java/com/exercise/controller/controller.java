package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exercise.entity.Artist;
import com.exercise.service.RestService;

@RestController
@RequestMapping("/service")
public class controller {
	
	@Autowired
	RestService restService;
	
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	 public @ResponseBody void process(@PathVariable("id") String id){
		

	  }
}
