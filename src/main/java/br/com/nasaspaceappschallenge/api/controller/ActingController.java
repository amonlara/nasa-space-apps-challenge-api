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

import br.com.nasaspaceappschallenge.api.assembler.ActingInputDisassembler;
import br.com.nasaspaceappschallenge.api.assembler.ActingModelAssembler;
import br.com.nasaspaceappschallenge.api.input.ActingInput;
import br.com.nasaspaceappschallenge.api.model.ActingModel;
import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.service.ActingService;

@RestController
@RequestMapping("/actings")
public class ActingController {
	
	
	@Autowired
	private ActingInputDisassembler actingInputDisassembler;
	
	@Autowired
	private ActingModelAssembler actingModelAssembler;
	
	@Autowired
	private ActingService actingService;
	
	
	@GetMapping
	public List<ActingModel> getAllActings() {
		List<Acting> findAll = actingService.findAll();
		return actingModelAssembler.toCollectionModel(findAll);
	}
	
	@GetMapping("/{id}")
	public ActingModel getActingById(@PathVariable Long id) {
		Acting eventById = actingService.findById(id);
		ActingModel model = actingModelAssembler.toModel(eventById);
		
		actingService.fillStaticalInfo(model);
		
		
		return model;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ActingModel create(@Valid @RequestBody ActingInput actingInput) {
		
		Acting acting = actingInputDisassembler.toDomainObject(actingInput);

		ActingModel actingModel = actingModelAssembler.toModel(actingService.save(acting));
		
		return actingModel;
	}

	
	
}
