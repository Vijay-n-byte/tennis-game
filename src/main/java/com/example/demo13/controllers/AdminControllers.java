package com.example.demo13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo13.dto.Matchdto;
import com.example.demo13.dto.Matchupdatedto;
import com.example.demo13.dto.Pointerdto;
import com.example.demo13.dto.Tossdetailsdto;
import com.example.demo13.service.Sampleservice;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/admin")
public class AdminControllers {

	@Autowired
	private Sampleservice ss;
	
	@PostMapping("/match")
	public String createMatch(@RequestBody Matchdto d){
		return ss.createMatch(d);
	}
	
	@PutMapping("/startmatch")
	public Pointerdto addTossResult(@RequestBody Tossdetailsdto d) {
		return ss.addTossDetails(d);
	}
	
	@GetMapping("/match/{id}")
	public Pointerdto resumeGame(@PathVariable String id) {
		return ss.resumeMatchUpdate(id);
	}
	
	@PutMapping("/match")
	public Pointerdto updateMatch(@RequestBody Matchupdatedto d) {
		return ss.updateMatch(d);
	}
}
