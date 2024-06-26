package com.example.demo13.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo13.entities.dum;

@Repository
public interface Samplerepo2 extends ReactiveMongoRepository<dum,Integer>{

}
