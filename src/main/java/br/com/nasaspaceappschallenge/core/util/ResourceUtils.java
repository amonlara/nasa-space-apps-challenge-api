package br.com.nasaspaceappschallenge.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nasaspaceappschallenge.domain.model.Event;

public class ResourceUtils {

	public static String getContentFromResource(String resourceName) {
		try {
			InputStream stream = ResourceUtils.class.getResourceAsStream(resourceName);
			return StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<Event>  loadEventsFromJson(String string) throws JsonMappingException, JsonProcessingException {
		String partner = getContentFromResource(
				string);
		
		ObjectMapper mapper = new ObjectMapper();
		List<Event> eventList = mapper.readValue(partner,  new TypeReference<List<Event>>(){});

		return eventList;
	}
	
}