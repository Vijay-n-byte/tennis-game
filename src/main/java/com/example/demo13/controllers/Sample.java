package com.example.demo13.controllers;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo13.dto.Matchdto;
import com.example.demo13.dto.Matchupdatedto;
import com.example.demo13.dto.Pointerdto;
import com.example.demo13.dto.Tossdetailsdto;
import com.example.demo13.entities.dum;
import com.example.demo13.entities.Match;
import com.example.demo13.entities.Pointer;
import com.example.demo13.repo.Samplerepo;
import com.example.demo13.service.Sampleservice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins="*")
public class Sample {
	@Autowired
	private Sampleservice ss;
	
//	@PostMapping("/create")
//	public String createMatch(@RequestBody Matchdto d){
//		return ss.create1(d);
//	}
//	
//	@PutMapping("/matchdetails")
//	public Pointerdto addTossResult(@RequestBody Tossdetailsdto d) {
//		return ss.addtossdetails(d);
//	}
//	
//	@GetMapping("/one/{id}")
//	public Pointerdto resumeGame(@PathVariable String id) {
//		return ss.resumeMatchUpdate(id);
//	}
//	
//	@PutMapping("/one")
//	public Pointerdto updateMatch(@RequestBody Matchupdatedto d) {
//		//gets update data and updates it and sends pointerdto
//		return ss.updateMatch(d);
//	}
	
//	//to produce dynamic data for match.
//	@GetMapping(path="/onee/{id}",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<Match> getmatchlivestream(@PathVariable String id) {
//		return ss.livestreammatch(id);
//	}
//	
//	@GetMapping(path="/one/future/{id}",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Match getmatchlivestream1(@PathVariable String id) {
//		try {
//			return ss.livestreammatch1(id).get();
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@PostMapping("/one1")
//	public void sam3(@RequestBody dum d){
//		System.out.println("created");
//		sr.gethh(d);
//	}
//	
//	@PutMapping("/one1")
//	public void sam4(@RequestBody dum d){
//		System.out.println("updateed");
//		sr.gethh1up(d);
//	}
//	 
//	@GetMapping(path="/one2/{id}",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<dum> sam333(@PathVariable int id) {
//		System.out.print("jjjhhgj");
//		return sr.getmap2(id).delayElements(Duration.ofMillis(20)).takeUntil(n->n.getNum2()==0);
//		//return sr.getmap2(id).flatMap(n->Flux.zip(Flux.interval(Duration.ofSeconds(20)),Flux.fromStream(Stream.generate(()->n))).map(Tuple2::getT2));
//	}
}
