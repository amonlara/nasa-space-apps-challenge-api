package br.com.nasaspaceappschallenge.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class PointValidator implements ConstraintValidator<PointValid, GeoJsonPoint> {
 
	/**
	 * {@inheritDoc}
	 */
    @Override
    public void initialize(final PointValid point) {
    	// No post initialization operation needed, but the method must be declares to complies with spring boot standards.
    }
 
    /**
	 * Validates whether a point is not blank.
	 */
    @Override 
    public boolean isValid(final GeoJsonPoint point, final ConstraintValidatorContext cxt) {
        return point != null && !point.toString().trim().isEmpty();
    }

}