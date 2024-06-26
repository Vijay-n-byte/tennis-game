package com.example.demo13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo13.entities.Match;
import com.example.demo13.service.Sampleservice;

import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/user")
public class UserControllers {

	@Autowired
	private Sampleservice ss;
	
	@GetMapping(path="/match/{id}",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Match> getmatchlivestream(@PathVariable String id) {
		System.out.print(id);
		return ss.livestreammatch(id);
	}
}
