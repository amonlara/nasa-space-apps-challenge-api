package br.com.nasaspaceappschallenge.domain.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;

public class MultiPolygonValidator implements ConstraintValidator<MultiPolygonValid, GeoJsonMultiPolygon> {
 
	/**
	 * {@inheritDoc}
	 */
    @Override
    public void initialize(final MultiPolygonValid multiPolygon) {
    	// No post initialization operation needed, but the method must be declares to complies with spring boot standards.
    }
 
    /**
	 * Validates whether a MultiPolygon is not blank.
	 */
    @Override 
    public boolean isValid(final GeoJsonMultiPolygon multiPolygon, final ConstraintValidatorContext cxt) {
        return multiPolygon != null && !multiPolygon.toString().trim().isEmpty();
    }

}