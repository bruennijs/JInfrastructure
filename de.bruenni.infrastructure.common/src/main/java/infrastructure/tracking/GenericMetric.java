package infrastructure.tracking;

/**
 * Created by bruenni on 16.01.17.
 */
class GenericMetric implements Metric {
	private String name;
	private Double factor;

	/**
	 * Constructor
	 * @param name name of the metric
	 * @param multiplier
	 */
	public GenericMetric(String name, Double multiplier) {
		this.name = name;
		this.factor = multiplier;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GenericMetric that = (GenericMetric) o;

		return factor.equals(that.factor);
	}

	@Override
	public int hashCode() {
		return factor.hashCode();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double get() {
		return factor;
	}

	@Override
	public Double getFactor() {
		return factor;
	}
}
