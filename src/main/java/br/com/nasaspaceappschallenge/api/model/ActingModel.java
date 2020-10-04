package br.com.nasaspaceappschallenge.api.model;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointSerializer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActingModel {

	private String id;
	
	private String name;
	
	@JsonSerialize(using = GeoJsonPointSerializer.class)
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint address; 
	
	private AgentModel agent;

	private ActingStatisticalModel statistical;


}
