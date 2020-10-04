package br.com.nasaspaceappschallenge.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nasaspaceappschallenge.api.model.ActingModel;
import br.com.nasaspaceappschallenge.api.model.ActingStatisticalModel;
import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.model.Agent;
import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.model.exception.EntityNotFoundException;
import br.com.nasaspaceappschallenge.domain.model.exception.EntityValidationException;
import br.com.nasaspaceappschallenge.domain.repository.ActingRepository;

@Service
public class ActingService {
	
	@Autowired
	private ActingRepository actingRepository;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	public Acting save(@Valid Acting acting) {

		validateAgent(acting);
		acting.setId(sequenceGeneratorService.generateSequence(Acting.SEQUENCE_NAME));
		Acting save = actingRepository.save(acting);

		//CHAMAR api estatistica AVISANDO SOBRE A CRIAÇÃO DO novo ativo
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(
				"http://api-statistical-spaceapps2020.herokuapp.com/api/ativo/" + save.getId(),
				save, 
				String.class);
		
		System.out.println("Retorno api statistical" + response);
		
		return save;
	}
	
	private void validateAgent(@Valid Acting acting) {

		Agent findById = agentService.findById(acting.getAgent().getId());
		acting.setAgent(findById);
		
	}

	public List<Acting> findAll() {
		return actingRepository.findAll();
	}
	
	public Acting findById(Long id) {
		return actingRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Não foi possivel achar um ativo com o id = " + id));
	}

	public void fillStaticalInfo(ActingModel model) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<ActingStatisticalModel> response = restTemplate.getForEntity(
				"http://api-statistical-spaceapps2020.herokuapp.com/api/ativo/" + model.getId(),
				ActingStatisticalModel.class);
		
		System.out.println("Retorno api statistical" + response);

		model.setStatistical(response.getBody());
		
	}

}
