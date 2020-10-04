package br.com.nasaspaceappschallenge.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointDeserializer;
import br.com.nasaspaceappschallenge.domain.model.serializer.GeoJsonPointSerializer;
import br.com.nasaspaceappschallenge.domain.validation.PointValid;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Acting {
	
	@Transient
    public static final String SEQUENCE_NAME = "actings_sequence";
	
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	
	@NotNull
	private String name;
	
	@PointValid
    @GeoSpatialIndexed(name = "address_index", type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonSerialize(using = GeoJsonPointSerializer.class)
    @JsonDeserialize(using = GeoJsonPointDeserializer.class)
    private GeoJsonPoint address;
	
	private Agent agent;

}
