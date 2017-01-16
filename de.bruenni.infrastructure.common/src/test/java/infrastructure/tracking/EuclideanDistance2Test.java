package infrastructure.tracking;

import infrastructure.tracking.distance.Distance;
import infrastructure.tracking.distance.EuclideanDistance2;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/**
 * Created by bruenni on 16.01.17.
 */
@RunWith(JUnit4.class)
public class EuclideanDistance2Test {
	@Test
	public void when_distance_expect_correct_result()
	{
		EuclideanDistance2 sut = new EuclideanDistance2();
		GeoPoint p1 = new GeoPoint(50.0359, 5.4253);
		GeoPoint p2 = new GeoPoint(50.3838, 5.0412);
		Distance<Double> distance = sut.distance(p1, p2, Metrics.KILOMETER);

		BigDecimal bigDecimal = new BigDecimal(distance.get());
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

		Assert.assertThat(bigDecimal.doubleValue(), IsEqual.equalTo(47.36));
	}

	@Test
	public void when_distance_expect_correct_result_for_meters()
	{
		EuclideanDistance2 sut = new EuclideanDistance2();
		GeoPoint p1 = new GeoPoint(50.0359, 5.4253);
		GeoPoint p2 = new GeoPoint(50.3838, 5.0412);
		Distance<Double> distance = sut.distance(p1, p2, Metrics.METER);

		BigDecimal bigDecimal = new BigDecimal(distance.get());
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

		Assert.assertThat(bigDecimal.doubleValue(), IsEqual.equalTo(47364.48));
	}
}
