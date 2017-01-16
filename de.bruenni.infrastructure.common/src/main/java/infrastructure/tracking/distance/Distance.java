package infrastructure.tracking.distance;

import infrastructure.tracking.Metric;

import java.util.function.Supplier;

/**
 * Created by bruenni on 16.01.17.
 */
public interface Distance<T> extends Supplier<T> {
	/**
	 * Gets the metric
	 * @return
	 */

	Metric getMetric();

	/**
	 * Gets the value.
	 * @return
	 */
	T get();
}
