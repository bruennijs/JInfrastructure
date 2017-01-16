package infrastructure.tracking.distance;

import infrastructure.tracking.Metric;

/**
 * Created by bruenni on 16.01.17.
 */
public class DistanceImpl<T> implements Distance<T> {
	private T value;
	private Metric metric;

	/**
	 * Constructor.
	 * @param value
	 * @param metric
	 */
	public DistanceImpl(T value, Metric metric) {
		this.value = value;
		this.metric = metric;
	}

	@Override
	public Metric getMetric() {
		return metric;
	}

	@Override
	public T get() {
		return value;
	}

	/**
	 * Distance with type double.
	 * @param v
	 * @param metric
	 * @param <T>
	 * @return
	 */
	public static <T extends Double> Distance<Double> from(double v, Metric metric) {
		return new DistanceImpl<>(v, metric);
	}
}
