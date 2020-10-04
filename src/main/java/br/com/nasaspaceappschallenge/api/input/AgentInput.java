package br.com.nasaspaceappschallenge.api.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonMultiPolygonSerializer;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointSerializer;
import br.com.nasaspaceappschallenge.domain.validation.MultiPolygonValid;
import br.com.nasaspaceappschallenge.domain.validation.PointValid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentInput {
	
	@NotNull
	private String name;
	
	@PointValid
	@JsonSerialize(using = GeoJsonPointSerializer.class)
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint address; 
	
	
}
