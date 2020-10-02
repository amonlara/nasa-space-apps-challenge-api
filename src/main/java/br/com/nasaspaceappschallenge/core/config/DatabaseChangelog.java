//package br.com.nasaspaceappschallenge.core.config;
//
//import java.util.List;
//
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.github.mongobee.changeset.ChangeLog;
//import com.github.mongobee.changeset.ChangeSet;
//
//import br.com.nasaspaceappschallenge.core.util.ResourceUtils;
//import br.com.nasaspaceappschallenge.domain.model.Event;
//
//@ChangeLog
//public class DatabaseChangelog {
//  
//  @ChangeSet(order = "001", id = "001", author = "amonlara")
//  public void importantWorkToDo(MongoTemplate mongoTemplate){
//	  
//	try {
//		List<Event> lisEvents = ResourceUtils.loadEventsFromJson("/data/json/events.json");
//		lisEvents.forEach(event -> mongoTemplate.save(event) );
//	} catch (JsonMappingException e) {
//		e.printStackTrace();
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	}
//
//	  
//  }
//
//
//}