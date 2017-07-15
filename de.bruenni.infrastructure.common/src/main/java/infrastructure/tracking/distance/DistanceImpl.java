package infrastructure.tracking.distance;

import infrastructure.tracking.Metric;

/**
 * Created by bruenni on 16.01.17.
 */
public abstract class DistanceImpl<T> implements Distance<T> {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DistanceImpl<?> distance = (DistanceImpl<?>) o;

		if (!value.equals(distance.value)) return false;
		return metric.equals(distance.metric);
	}

	@Override
	public int hashCode() {
		int result = value.hashCode();
		result = 31 * result + metric.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "DistanceImpl{" +
				"value=" + value +
				", metric=" + metric +
				'}';
	}
}
