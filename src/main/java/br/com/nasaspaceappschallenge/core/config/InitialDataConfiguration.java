package br.com.nasaspaceappschallenge.core.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.nasaspaceappschallenge.core.util.ResourceUtils;
import br.com.nasaspaceappschallenge.domain.model.Event;
import br.com.nasaspaceappschallenge.domain.repository.ActingRepository;
import br.com.nasaspaceappschallenge.domain.repository.AgentRepository;
import br.com.nasaspaceappschallenge.domain.repository.EventRepository;

@Configuration
public class InitialDataConfiguration {

	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ActingRepository actingRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
    @PostConstruct
    public void postConstruct() {
        System.out.println("Started after Spring boot application !");
        
		try {
//			eventRepository.deleteAll();
//			actingRepository.deleteAll();
//			agentRepository.deleteAll();
//			
			List<Event> lisEvents = ResourceUtils.loadEventsFromJson("/data/json/events.json");
//			eventRepository.saveAll(lisEvents);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}