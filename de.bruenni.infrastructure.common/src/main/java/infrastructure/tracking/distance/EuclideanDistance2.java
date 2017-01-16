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
		double dist = Math.sin(deg2rad(p1.getLatitude())) * Math.sin(deg2rad(p2.getLatitude())) + Math.cos(deg2rad(p1.getLatitude())) * Math.cos(deg2rad(p2.getLatitude())) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (metric == Metrics.KILOMETER) {
			dist = dist * 1.609344;
		}
		else if (metric == Metrics.METER) {
			dist = dist * 1609.344;
		}

		return DistanceImpl.from(dist, metric);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
