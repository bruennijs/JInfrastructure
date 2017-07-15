package infrastructure.tracking;

import java.util.function.Supplier;

/**
 * Created by bruenni on 16.01.17.
 * The multiplier is a factor to scale up/down from centimeters.
 */
public interface Metric extends Supplier<Double> {

	/**
	 * Gets the name of the metric
	 * @return
	 */
	String getName();

	/**
	 * Gets the factor of the multiplier with base of centimeter.
	 * @return
	 */
    Double getFactor();
}
