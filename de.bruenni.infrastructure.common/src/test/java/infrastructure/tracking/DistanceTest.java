package infrastructure.tracking;

import infrastructure.tracking.distance.Distance;
import infrastructure.tracking.distance.DistanceImpl;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/**
 * Created by bruenni on 15.07.17.
 */
@RunWith(JUnit4.class)
public class DistanceTest {
    @Test
    public void when_plus_expect_result_matches() throws Exception {
        Distance<BigDecimal> tenCm = Distance.from(BigDecimal.valueOf(10), Metrics.CENTIMETER);
        Distance<BigDecimal> twentyDot5Cm = Distance.from(BigDecimal.valueOf(20.5), Metrics.CENTIMETER);

        Assert.assertThat(tenCm.plus(twentyDot5Cm), IsEqual.equalTo(Distance.from(BigDecimal.valueOf(30.5), Metrics.CENTIMETER)));
    }

    @Test
    public void when_plus_expect_result_matches_left_operands_metric() throws Exception {
        Distance<BigDecimal> leftOp = Distance.from(BigDecimal.valueOf(3.4), Metrics.METER);
        Distance<BigDecimal> rightOp = Distance.from(BigDecimal.valueOf(25.5), Metrics.CENTIMETER);

        Assert.assertThat(leftOp.plus(rightOp), IsEqual.equalTo(Distance.from(BigDecimal.valueOf(3.655), Metrics.METER)));
    }
}
