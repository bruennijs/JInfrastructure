package infrastructure.time;

import java.time.Duration;
import java.time.Instant;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.*;

/**
 * Created by bruenni on 14.01.17.
 */
public class BucketAdjuster implements TemporalAdjuster {
	private Duration bucketPeriod;

	public BucketAdjuster(Duration bucketPeriod) {
		this.bucketPeriod = bucketPeriod;
	}

	@Override
	public Temporal adjustInto(Temporal temporal) {
		Instant time = Instant.from(temporal);
		//time.truncatedTo(new ChronoUnit("15MINUTE_BUCKET", Duration.of(5, ChronoUnit.MINUTES)));
		long periodInMillis = bucketPeriod.toMillis();

		long fraction = time.toEpochMilli() % periodInMillis;

		Instant adjusted = time.minus(fraction, ChronoUnit.MILLIS);

		return adjusted;
	}
}
