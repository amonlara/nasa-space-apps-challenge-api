package br.com.nasaspaceappschallenge.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.model.Agent;
import br.com.nasaspaceappschallenge.domain.model.Agent;
import br.com.nasaspaceappschallenge.domain.model.exception.EntityNotFoundException;
import br.com.nasaspaceappschallenge.domain.model.exception.EntityValidationException;
import br.com.nasaspaceappschallenge.domain.repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	public Agent save(@Valid Agent agent) {

		validateActings(agent.getActings());

		agent.setId(sequenceGeneratorService.generateSequence(Agent.SEQUENCE_NAME));
		
		

		return agentRepository.save(agent);
	}
	
	private void validateActings(List<Acting> actings) {

		
		
	}

	public List<Agent> findAll() {
		return agentRepository.findAll();
	}
	
	public Agent findById(Long id) {
		return agentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Não foi possivel achar um agente com o id = " + id));
	}

}
