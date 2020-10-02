package br.com.nasaspaceappschallenge.domain.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nasaspaceappschallenge.api.filter.EventLatLongFilter;
import br.com.nasaspaceappschallenge.core.latlong.LatLongUtil;
import br.com.nasaspaceappschallenge.domain.model.Event;
import br.com.nasaspaceappschallenge.domain.model.exception.EntityNotFoundException;
import br.com.nasaspaceappschallenge.domain.model.exception.EntityValidationException;
import br.com.nasaspaceappschallenge.domain.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private LatLongUtil latLongutil;

	public Event save(@Valid Event event) {

		validateId(event);

		return eventRepository.save(event);
	}

	public Event findByLatLong(EventLatLongFilter partnerLatLongfilter) {

		List<Event> findByCoverageAreaNear = eventRepository
				.findByCoverageAreaNear(partnerLatLongfilter.getLongitude(), partnerLatLongfilter.getLatitude());
		
		if(findByCoverageAreaNear.isEmpty()) {
			throw new EntityNotFoundException("Não foi possivel encontrar nenhum evento para essa localidade");
		}
//		
		findByCoverageAreaNear.forEach(event -> event.setDistance(latLongutil.calculateDistanceInMeters
				(partnerLatLongfilter.getLatitude(), partnerLatLongfilter.getLongitude(),
						event.getAddress().getY(), event.getAddress().getX())));
		
		Event event = findByCoverageAreaNear
				.stream()
			      .min(Comparator.comparing(Event::getDistance))
			      .get();
	
		return event;
		
	}

	public Event findById(String id) {
		return eventRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Não foi possivel achar um evento com o id = " + id));
	}

	private void validateId(Event event) {
		Optional<Event> findById = eventRepository.findById(event.getId());

		if (findById.isPresent()) {
			throw new EntityValidationException(String.format("Já existe um evento de nome %s com o id %s.",
					findById.get().getName(), findById.get().getId()));
		}

	}

	public List<Event> findAll() {
		return eventRepository.findAll();
	}
}
