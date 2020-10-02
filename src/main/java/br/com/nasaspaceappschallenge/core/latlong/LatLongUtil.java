package br.com.nasaspaceappschallenge.core.latlong;

import java.awt.geom.Point2D;

import org.springframework.stereotype.Component;

@Component
public class LatLongUtil {

	public double calculateDistanceInMeters(double lat1, double long1, double lat2, double long2) {
	    return Point2D.distance(lat1, long1, lat2, long2);
	}

}
