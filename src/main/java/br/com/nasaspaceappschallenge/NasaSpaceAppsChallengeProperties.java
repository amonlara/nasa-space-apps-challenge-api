package br.com.nasaspaceappschallenge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("nasa-space-apps-challenge.application")
public class NasaSpaceAppsChallengeProperties {
	
	  private String allowedOrigin;

}