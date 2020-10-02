package br.com.nasaspaceappschallenge.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonMultiPolygonDeserializer;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonMultiPolygonSerializer;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointDeserializer;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointSerializer;
import br.com.nasaspaceappschallenge.domain.validation.MultiPolygonValid;
import br.com.nasaspaceappschallenge.domain.validation.PointValid;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Event {
	
	
	@EqualsAndHashCode.Include
	@NotNull
	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@PointValid
    @GeoSpatialIndexed(name = "address_index", type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonSerialize(using = GeoJsonPointSerializer.class)
    @JsonDeserialize(using = GeoJsonPointDeserializer.class)
    private GeoJsonPoint address; 
	
	@MultiPolygonValid
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonSerialize(using = GeoJsonMultiPolygonSerializer.class)
    @JsonDeserialize(using = GeoJsonMultiPolygonDeserializer.class)
	private GeoJsonMultiPolygon coverageArea;
	
	@Transient
	private double distance;

}
