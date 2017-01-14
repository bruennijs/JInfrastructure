package infrastructure.time;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by bruenni on 14.01.17.
 */
@RunWith(JUnit4.class)
public class BucketAdjusterTest {
	@Test
	public void when_adjust_to_5_minute_expect_round_down()
	{
		Instant time = Instant.parse("2001-01-01T13:16:59Z");
		Instant adjustedTime = time.with(new BucketAdjuster(Duration.ofMinutes(5)));
		Assert.assertThat(adjustedTime, IsEqual.equalTo(Instant.parse("2001-01-01T13:15:00Z")));
	}

	@Test
	public void when_adjust_to_5_minute_expect_round_down_when_closer_to_upper()
	{
		Instant time = Instant.parse("2001-01-01T13:19:59Z");
		Instant adjustedTime = time.with(new BucketAdjuster(Duration.ofMinutes(5)));
		Assert.assertThat(adjustedTime, IsEqual.equalTo(Instant.parse("2001-01-01T13:15:00Z")));
	}

	@Test
	public void when_adjust_to_1_seconds_expect_round_down_when_closer_to_upper()
	{
		Instant time = Instant.parse("2001-01-01T13:19:59.099Z");
		Instant adjustedTime = time.with(new BucketAdjuster(Duration.ofSeconds(1)));
		Assert.assertThat(adjustedTime, IsEqual.equalTo(Instant.parse("2001-01-01T13:19:59.000Z")));
	}
}
