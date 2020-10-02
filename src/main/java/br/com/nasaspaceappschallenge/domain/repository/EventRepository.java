package br.com.nasaspaceappschallenge.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.nasaspaceappschallenge.domain.model.Event;

public interface EventRepository extends MongoRepository<Event, String> {
	
	
	 @Query("{ coverageArea:"
		 		+ " 	{ $geoIntersects:"
		 		+ "			 { $geometry: "
		 		+ "				{ type: \"Point\", coordinates: [ ?0,  ?1 ] }"
		 		+ "			 }"
		 		+ "		 }"
		 		+ "}"
		 		)
		 List<Event> findByCoverageAreaNear(Double longitude, Double latitude);

}
