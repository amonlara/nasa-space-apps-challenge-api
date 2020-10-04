package br.com.nasaspaceappschallenge.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.nasaspaceappschallenge.domain.model.Agent;

public interface AgentRepository extends MongoRepository<Agent, Long> {
	

}
