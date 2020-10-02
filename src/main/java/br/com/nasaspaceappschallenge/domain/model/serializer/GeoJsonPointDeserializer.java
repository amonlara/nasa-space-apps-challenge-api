package br.com.nasaspaceappschallenge.domain.model.serializer;

import java.io.IOException;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class GeoJsonPointDeserializer extends JsonDeserializer<GeoJsonPoint> {

	@Override
	public GeoJsonPoint deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		JsonNode coordinates = node.get("coordinates");

		if (coordinates != null && coordinates.isArray()) {
			return doDeserialize((ArrayNode) coordinates);
		}
		return null;
	}
	
	protected GeoJsonPoint doDeserialize(ArrayNode coordinates) {
		return toGeoJsonPoint(coordinates);
	}
	
	protected GeoJsonPoint toGeoJsonPoint(@Nullable ArrayNode node) {

		if (node == null) {
			return null;
		}

		return new GeoJsonPoint(node.get(0).asDouble(), node.get(1).asDouble());
	}


}