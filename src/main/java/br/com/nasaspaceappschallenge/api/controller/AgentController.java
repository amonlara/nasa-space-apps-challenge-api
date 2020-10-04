package br.com.nasaspaceappschallenge.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.nasaspaceappschallenge.api.assembler.AgentInputDisassembler;
import br.com.nasaspaceappschallenge.api.assembler.AgentModelAssembler;
import br.com.nasaspaceappschallenge.api.input.AgentInput;
import br.com.nasaspaceappschallenge.api.model.AgentModel;
import br.com.nasaspaceappschallenge.domain.model.Agent;
import br.com.nasaspaceappschallenge.domain.model.Agent;
import br.com.nasaspaceappschallenge.domain.service.AgentService;

@RestController
@RequestMapping("/agents")
public class AgentController {
	
	
	@Autowired
	private AgentInputDisassembler agentInputDisassembler;
	
	@Autowired
	private AgentModelAssembler agentModelAssembler;
	
	@Autowired
	private AgentService agentService;
	
	
	@GetMapping
	public List<AgentModel> getAllAgents() {
		List<Agent> findAll = agentService.findAll();
		return agentModelAssembler.toCollectionModel(findAll);
	}
	
	@GetMapping("/{id}")
	public AgentModel getAgentById(@PathVariable Long id) {
		Agent byId = agentService.findById(id);
		return agentModelAssembler.toModel(byId);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgentModel create(@Valid @RequestBody AgentInput actingInput) {
		Agent agent = agentInputDisassembler.toDomainObject(actingInput);

		AgentModel agentModel = agentModelAssembler.toModel(agentService.save(agent));
		
		return agentModel;
	}

	
	
}
