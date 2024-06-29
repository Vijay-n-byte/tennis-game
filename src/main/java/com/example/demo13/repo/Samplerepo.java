package com.example.demo13.repo;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo13.dto.Matchupdatedto;
import com.example.demo13.entities.Match;
import com.example.demo13.entities.Pointer;
import com.example.demo13.entities.Tennis_set;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Transactional
public class Samplerepo {
	
	@Autowired
	private ReactiveMongoTemplate mt;
	
	@Autowired
	private MongoTemplate mt1;
	
	public void creatematchrepo(Match m) {
		mt.insert(m).subscribe();
	}
    public void insertPointer(String id,Pointer p) {
    	Query t=new Query();
		t.addCriteria(Criteria.where("matchid").is(id));
		Update u=new Update();
		u.set("pointer", p);
		mt1.updateMulti(t, u, Match.class);
    }
	public List<Pointer> getPointerForMatch(String id) {
		Query t=new Query();
		t.addCriteria(Criteria.where("matchid").is(id));
		return mt1.findDistinct(t,"pointer",Match.class, Pointer.class);
	}
	public Match getmatchdetails(String id) {
		return mt1.findById(id, Match.class);
	}
	public void updatematchrepo(Match match) {
		Query t=new Query();
		t.addCriteria(Criteria.where("matchid").is(match.getMatchid()));
		Update u=new Update();
		u.set("sets", match.getSets());
		u.set("pointer", match.getPointer());
		u.set("wt", match.getWt());
		u.set("bestsetscore", match.getBestsetscore());
		u.set("status", match.getStatus());
		mt1.updateMulti(t, u, Match.class);
	}
	
	public List<String> getLiveMatchid() {
		Query t=new Query();
		t.addCriteria(Criteria.where("status").is("started"));
		List<Match> m=mt1.find(t, Match.class);
		List<String> h=m.stream().map(n->n.getMatchid()).collect(Collectors.toList());
		return h;
	}
	
	public Flux<Match> getMatchlivestream(String id) {
		return mt.findById(id, Match.class).repeat();
	}
}
