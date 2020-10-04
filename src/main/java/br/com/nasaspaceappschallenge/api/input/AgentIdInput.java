package br.com.nasaspaceappschallenge.api.input;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AgentIdInput {
	
//	@NotNull
	private Long id;

}
