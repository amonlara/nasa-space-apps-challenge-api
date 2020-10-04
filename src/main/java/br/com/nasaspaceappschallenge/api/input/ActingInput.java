package br.com.nasaspaceappschallenge.api.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.nasaspaceappschallenge.domain.model.Agent;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointSerializer;
import br.com.nasaspaceappschallenge.domain.validation.PointValid;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ActingInput {
	
	@NotNull
	private String name;
	
	@PointValid
	@JsonSerialize(using = GeoJsonPointSerializer.class)
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint address; 
	
//	@Valid
//	@NotNull
	private AgentIdInput agent;
	
}
