package br.com.nasaspaceappschallenge.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nasaspaceappschallenge.api.model.FireModel;
import br.com.nasaspaceappschallenge.domain.model.Acting;
import br.com.nasaspaceappschallenge.domain.service.FireService;

@RestController
@RequestMapping("/fires")
public class FireController {
	
	@Autowired
	private FireService fireService;
	
	@GetMapping
	public List<FireModel> getAllActings() {
		return fireService.findAll();
	}

}
