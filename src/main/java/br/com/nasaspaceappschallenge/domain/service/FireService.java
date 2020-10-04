package br.com.nasaspaceappschallenge.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nasaspaceappschallenge.api.model.ActingStatisticalModel;
import br.com.nasaspaceappschallenge.api.model.FireModel;

@Service
public class FireService {

	public List<FireModel> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<FireModel[]> response = restTemplate.getForEntity(
				"http://queimadas.dgi.inpe.br/queimadas/dados-abertos/api/focos?estado_id=13&pais_id=33",
				FireModel[].class);
		
		List<FireModel> asList = Arrays.asList(response.getBody());
		
		return asList;
	}
	
	
	

}
