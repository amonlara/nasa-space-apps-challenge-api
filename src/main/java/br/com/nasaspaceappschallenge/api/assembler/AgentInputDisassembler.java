package br.com.nasaspaceappschallenge.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nasaspaceappschallenge.api.input.AgentInput;
import br.com.nasaspaceappschallenge.domain.model.Agent;

@Component
public class AgentInputDisassembler {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Agent toDomainObject(AgentInput agentInput) {
		return modelMapper.map(agentInput, Agent.class);
	}

}
