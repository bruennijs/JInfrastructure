package infrastructure.tracking.distance;

import infrastructure.tracking.Metric;
import infrastructure.tracking.Metrics;

/**
 * Created by bruenni on 15.07.17.
 */
public class DistanceDouble extends DistanceImpl<Double> {

    /**
     * Constructor.
     *
     * @param value
     * @param metric
     */
    public DistanceDouble(Double value, Metric metric) {
        super(value, metric);
    }

    @Override
    public Distance<Double> plus(Distance<Double> summand) {
        return new DistanceDouble((this.get() * getMetric().getFactor()) + (summand.get() * summand.getMetric().getFactor()), Metrics.CENTIMETER);
    }
}
