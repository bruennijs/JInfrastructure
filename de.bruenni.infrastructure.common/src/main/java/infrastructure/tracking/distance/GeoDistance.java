package infrastructure.tracking.distance;

import infrastructure.tracking.GeoPoint;
import infrastructure.tracking.Metric;

/**
 * Created by bruenni on 16.01.17.
 */
public interface GeoDistance {
	/***
	 * Calculates the distance between
	 * @param p1 point 1
	 * @param p2 point 2
	 * @return distance in
	 */
	<GP extends GeoPoint, R extends Double> Distance<R> distance(final GP p1, final GP p2, Metric metric);
}
