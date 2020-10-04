package br.com.nasaspaceappschallenge.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nasaspaceappschallenge.api.model.AgentModel;
import br.com.nasaspaceappschallenge.domain.model.Agent;

@Component
public class AgentModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public AgentModel toModel(Agent agent) {
		
		AgentModel agentModel = new AgentModel();
		
		modelMapper.map(agent, agentModel);
		
		return agentModel;
	}


	public List<AgentModel> toCollectionModel(List<Agent> findAll) {
		List<AgentModel> toCollectionModel = new ArrayList<>();
		findAll.forEach( agent -> toCollectionModel.add(toModel(agent)));
		return toCollectionModel;
	}

}
