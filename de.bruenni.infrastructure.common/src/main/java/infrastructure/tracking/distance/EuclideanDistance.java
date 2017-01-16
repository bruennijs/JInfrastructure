package infrastructure.tracking.distance;

import infrastructure.tracking.GeoPoint;
import infrastructure.tracking.Metric;

/**
 * Created by bruenni on 16.01.17.
 */
public class EuclideanDistance implements GeoDistance {
	@Override
	public Distance<Double> distance(final GeoPoint p1, GeoPoint p2, Metric metric) {
		double lonDiff = Math.abs(p1.getLongitude() - p2.getLongitude());
		double latDiff = Math.abs(p1.getLatitude() - p2.getLatitude());

		return DistanceImpl.from(0.0, metric);
	}
}
