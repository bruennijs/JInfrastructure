package infrastructure.tracking.distance;

import infrastructure.tracking.Metric;

import java.math.BigDecimal;
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

	/**
	 * Accumlation.
	 * @param summand
	 * @return
	 */
	Distance<T> plus(Distance<T> summand);

	/**
	 * Distance with type double.
	 * @param v
	 * @param metric
	 * @return
	 */
	static Distance<Double> from(double v, Metric metric) {
		return new DistanceDouble(v, metric);
	}

	/**
	 * Distance with type double.
	 * @param value
	 * @param metric
	 * @return
	 */
	static Distance<BigDecimal> from(BigDecimal value, Metric metric) {
		return new DistanceBigDecimal(value, metric);
	}
}
