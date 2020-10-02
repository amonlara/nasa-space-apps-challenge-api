package br.com.nasaspaceappschallenge.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nasaspaceappschallenge.api.model.EventModel;
import br.com.nasaspaceappschallenge.domain.model.Event;

@Component
public class EventModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public EventModel toModel(Event event) {
		
		EventModel eventModel = new EventModel();
		
		modelMapper.map(event, eventModel);
		
		return eventModel;
	}


	public List<EventModel> toCollectionModel(List<Event> findAllEvent) {
		List<EventModel> toCollectionModel = new ArrayList<>();
		findAllEvent.forEach( event -> toCollectionModel.add(toModel(event)));
		return toCollectionModel;
	}

}
