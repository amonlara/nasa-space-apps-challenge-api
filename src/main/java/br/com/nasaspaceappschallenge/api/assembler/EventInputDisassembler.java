package br.com.nasaspaceappschallenge.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nasaspaceappschallenge.api.input.EventInput;
import br.com.nasaspaceappschallenge.domain.model.Event;

@Component
public class EventInputDisassembler {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Event toDomainObject(EventInput partnerInput) {
		return modelMapper.map(partnerInput, Event.class);
	}

}
