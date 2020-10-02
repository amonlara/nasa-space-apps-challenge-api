package br.com.nasaspaceappschallenge.domain.model.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class GeoJsonMultiPolygonDeserializer extends JsonDeserializer<GeoJsonMultiPolygon> {

	@Override
	public GeoJsonMultiPolygon deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
	
		
		JsonNode node = p.readValueAsTree();
		JsonNode coordinates = node.get("coordinates");

		if (coordinates != null && coordinates.isArray()) {
			return doDeserialize((ArrayNode) coordinates);
		}
		
		return null;
	}

	
	
	
	
		/*
		 * (non-Javadoc)
		 * @see org.springframework.data.mongodb.core.geo.GeoJsonModule.GeoJsonDeserializer#doDeserialize(com.fasterxml.jackson.databind.node.ArrayNode)
		 */
//		@Override
		protected GeoJsonMultiPolygon doDeserialize(ArrayNode coordinates) {
//
			List<GeoJsonPolygon> polygones = new ArrayList<GeoJsonPolygon>(coordinates.size());

			for (JsonNode polygon : coordinates) {
				for (JsonNode ring : polygon) {
					polygones.add(new GeoJsonPolygon(toPoints((ArrayNode) ring)));
				}
			}

			return new GeoJsonMultiPolygon(polygones);
		}
		
		protected List<Point> toPoints(@Nullable ArrayNode node) {

			if (node == null) {
				return Collections.emptyList();
			}

			List<Point> points = new ArrayList<Point>(node.size());

			for (JsonNode coordinatePair : node) {
				if (coordinatePair.isArray()) {
					points.add(toPoint((ArrayNode) coordinatePair));
				}
			}
			return points;
		}
		
		protected Point toPoint(@Nullable ArrayNode node) {

			if (node == null) {
				return null;
			}

			return new Point(node.get(0).asDouble(), node.get(1).asDouble());
		}
		

}