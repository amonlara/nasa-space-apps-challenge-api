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

import br.com.nasaspaceappschallenge.api.assembler.EventInputDisassembler;
import br.com.nasaspaceappschallenge.api.assembler.EventModelAssembler;
import br.com.nasaspaceappschallenge.api.filter.EventLatLongFilter;
import br.com.nasaspaceappschallenge.api.input.EventInput;
import br.com.nasaspaceappschallenge.api.model.EventModel;
import br.com.nasaspaceappschallenge.domain.model.Event;
import br.com.nasaspaceappschallenge.domain.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventInputDisassembler eventInputDisassembler;
	
	@Autowired
	private EventModelAssembler eventModelAssembler;
	
	@Autowired
	private EventService eventService;
	
	
	@GetMapping("/by-lat-long")
	public EventModel getEventByLatLong(EventLatLongFilter eventLatLongfilter) {
		Event eventById = eventService.findByLatLong(eventLatLongfilter);
		return eventModelAssembler.toModel(eventById);
	}
	
	
	@GetMapping
	public List<EventModel> getAllEvents() {
		List<Event> findAllEvent = eventService.findAll();
		return eventModelAssembler.toCollectionModel(findAllEvent);
	}
	
	@GetMapping("/{id}")
	public EventModel getEventById(@PathVariable String id) {
		Event eventById = eventService.findById(id);
		return eventModelAssembler.toModel(eventById);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EventModel create(@Valid @RequestBody EventInput eventInput) {
		Event partner = eventInputDisassembler.toDomainObject(eventInput);

		EventModel partnerModel = eventModelAssembler.toModel(eventService.save(partner));
		
		return partnerModel;
	}

}
