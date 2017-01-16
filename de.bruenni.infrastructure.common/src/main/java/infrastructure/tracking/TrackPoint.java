package infrastructure.tracking;

import java.time.Instant;
import java.util.Optional;

/**
 * Created by bruenni on 29.12.16.
 */
public class TrackPoint {
    private GeoPoint geoPoint;
    private final Double altitude;
        private final Optional<Instant> time;

        /**
         * Defines track point
         * @param altitude  - altitude in meters
         * @param time      - time point is registered
         */
        public TrackPoint(final GeoPoint geoPoint, final Double altitude, final Optional<Instant> time) {
					this.geoPoint = geoPoint;
					this.altitude = altitude;

					this.time = time;
				}

    @Override
    public String toString() {
        return String.format("[%1s, alt=%2s, time=%3s]", this.getPoint(), this.getAltitude(), this.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackPoint that = (TrackPoint) o;

        if (!geoPoint.equals(that.geoPoint)) return false;
        if (!altitude.equals(that.altitude)) return false;
        if (!time.equals(that.time)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = geoPoint.hashCode();
        result = 31 * result + altitude.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }

    public GeoPoint getPoint() {
        return geoPoint;
    }

    public Optional<Instant> getTime() {
            return time;
        }

    public Double getAltitude() {
            return altitude;
        }
}
