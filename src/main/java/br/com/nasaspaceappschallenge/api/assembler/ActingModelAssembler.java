package br.com.nasaspaceappschallenge.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nasaspaceappschallenge.api.model.ActingModel;
import br.com.nasaspaceappschallenge.domain.model.Acting;

@Component
public class ActingModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ActingModel toModel(Acting acting) {
		
		ActingModel actingModel = new ActingModel();
		
		modelMapper.map(acting, actingModel);
		
		return actingModel;
	}


	public List<ActingModel> toCollectionModel(List<Acting> findAllActing) {
		List<ActingModel> toCollectionModel = new ArrayList<>();
		findAllActing.forEach( acting -> toCollectionModel.add(toModel(acting)));
		return toCollectionModel;
	}

}
