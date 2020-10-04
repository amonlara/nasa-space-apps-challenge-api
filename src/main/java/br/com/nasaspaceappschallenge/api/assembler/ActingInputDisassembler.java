package br.com.nasaspaceappschallenge.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nasaspaceappschallenge.api.input.ActingInput;
import br.com.nasaspaceappschallenge.domain.model.Acting;

@Component
public class ActingInputDisassembler {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Acting toDomainObject(ActingInput actingInput) {
		return modelMapper.map(actingInput, Acting.class);
	}

}
