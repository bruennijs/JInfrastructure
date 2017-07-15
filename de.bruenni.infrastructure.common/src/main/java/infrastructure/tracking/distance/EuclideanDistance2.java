package infrastructure.tracking.distance;

import infrastructure.tracking.GeoPoint;
import infrastructure.tracking.Metric;
import infrastructure.tracking.Metrics;

/**
 * Created by bruenni on 16.01.17.
 */
public class EuclideanDistance2 implements GeoDistance {
	@Override
	public Distance<Double> distance(GeoPoint p1, GeoPoint p2, Metric metric) {
		double theta = p1.getLongitude() - p2.getLongitude();
		double dist = Math.sin(Math.toRadians(p1.getLatitude())) * Math.sin(Math.toRadians(p2.getLatitude())) + Math.cos(Math.toRadians(p1.getLatitude())) * Math.cos(Math.toRadians(p2.getLatitude())) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		if (metric == Metrics.KILOMETER) {
			dist = dist * 1.609344;
		}
		else if (metric == Metrics.METER) {
			dist = dist * 1609.344;
		}

		return Distance.from(dist, metric);
	}
}
