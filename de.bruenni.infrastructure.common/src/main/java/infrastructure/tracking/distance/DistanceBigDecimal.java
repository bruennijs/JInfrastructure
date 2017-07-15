package infrastructure.tracking.distance;

import infrastructure.tracking.Metric;
import infrastructure.tracking.Metrics;

import java.math.BigDecimal;

/**
 * Created by bruenni on 15.07.17.
 */
public class DistanceBigDecimal extends DistanceImpl<BigDecimal> {
    /**
     * Constructor.
     *
     * @param value
     * @param metric
     */
    public DistanceBigDecimal(BigDecimal value, Metric metric) {
        super(value, metric);
    }

    @Override
    public Distance<BigDecimal> plus(Distance<BigDecimal> summand) {
        BigDecimal thisMetricFactor = BigDecimal.valueOf(getMetric().getFactor());
        BigDecimal thisInCm = this.get().multiply(thisMetricFactor);
        BigDecimal summandInCm = summand.get().multiply(BigDecimal.valueOf(summand.getMetric().getFactor()));
        return new DistanceBigDecimal(thisInCm.add(summandInCm).divide(thisMetricFactor), this.getMetric());
    }
}
