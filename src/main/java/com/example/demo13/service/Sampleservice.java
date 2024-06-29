package com.example.demo13.service;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo13.repo.Samplerepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.demo13.dto.Matchdto;
import com.example.demo13.dto.Matchupdatedto;
import com.example.demo13.entities.Games;
import com.example.demo13.entities.Match;
import com.example.demo13.entities.Pointer;
import com.example.demo13.entities.Tennis_set;
import com.example.demo13.enums.Status;
import com.example.demo13.dto.Pointerdto;
import com.example.demo13.dto.Tossdetailsdto;
@Service
public class Sampleservice {
	@Autowired
	private Samplerepo sr;
	
	public String createMatch(Matchdto md) {
		Match m =new Match(md);
		sr.creatematchrepo(m);
		return m.getMatchid();
	}
	
	public Pointerdto addTossDetails(Tossdetailsdto d) {
		Pointer p=new Pointer(1,1,d.getFirstserveteam());
		sr.insertPointer(d.getMatchid(),p);
		return new Pointerdto(d.getMatchid(),Status.started,p);
	}
	
	public Pointerdto resumeMatchUpdate(String id) {
		Pointer m=sr.getPointerForMatch(id).get(0);
		Status s;
		if(m==null) {
			s=Status.ended;
		}
		else {
			s=Status.started; 
		}
		return new Pointerdto(id,s,m);
	}
	
	public Pointerdto updateMatch(Matchupdatedto m) {
		Match m1=sr.getmatchdetails(m.getMatchid());
		List<Tennis_set> b=m1.getSets();
		Tennis_set ts=updateTennisSet(b.get(m.getSetno()-1),m,m1.getPointer());
		m1.updateMatch(m.getSetno()-1,ts);
		sr.updatematchrepo(m1);
		Pointerdto p1=new Pointerdto(m.getMatchid(),m1.getStatus(),m1.getPointer());
		return p1;
	}
	private Tennis_set updateTennisSet(Tennis_set a,Matchupdatedto b,Pointer p) {
		Games g= a.giveGames(b.getGameno(),p.getServeside());
		g.addPoints(b.getS());
		a.updateGames(b.getGameno()-1, g);
		return a;
	}
	public List<String> getAllLiveMatchDetails(){
		return sr.getLiveMatchid();
	}
	
	//using springflux flux and mono
	public Flux<Match> livestreammatch(String id) {
		return sr.getMatchlivestream(id).delayElements(Duration.ofMillis(20));
	}
}
