package br.com.nasaspaceappschallenge.domain.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonLineString;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
 
import java.io.IOException;
import java.util.List;
 
public class GeoJsonMultiPolygonSerializer extends JsonSerializer<GeoJsonMultiPolygon> {
 
    @Override
    public void serialize(GeoJsonMultiPolygon value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("type", value.getType());
        gen.writeArrayFieldStart("coordinates");
     
        List<GeoJsonPolygon> p = value.getCoordinates();
        for (GeoJsonPolygon geoJsonPolygon : p) {
    		gen.writeStartArray();

        	for (GeoJsonLineString ls : geoJsonPolygon.getCoordinates()) {
        		gen.writeStartArray();
        		for (Point point : ls.getCoordinates()) {
        			gen.writeObject(new double[]{point.getX(), point.getY()});
        		}
        		gen.writeEndArray();
        	}
    		gen.writeEndArray();

		}
        
        
        
        gen.writeEndArray();
        gen.writeEndObject();
    }
}