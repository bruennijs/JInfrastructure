package infrastructure.tracking;

/**
 * Created by bruenni on 16.01.17.
 */
public class Metrics {
	public static final Metric KILOMETER = new GenericMetric("kilometer", Double.valueOf(100.0 * 1000.0));;
	/**
	 * metric of Meter.
	 */
	public static final Metric METER = new GenericMetric("meter", Double.valueOf(100.0));
}
