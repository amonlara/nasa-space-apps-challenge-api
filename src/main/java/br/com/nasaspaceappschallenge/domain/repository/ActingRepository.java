package br.com.nasaspaceappschallenge.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.model.Event;

public interface ActingRepository extends MongoRepository<Acting, Long> {
	

}
