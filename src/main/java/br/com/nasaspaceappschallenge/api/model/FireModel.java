package br.com.nasaspaceappschallenge.api.model;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointDeserializer;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointSerializer;

public class FireModel {
	

    @JsonDeserialize(using = GeoJsonPointDeserializer.class)
	@JsonSerialize(using = GeoJsonPointSerializer.class)
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint geometry; 

}
