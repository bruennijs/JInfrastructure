package infrastructure.tracking;

import java.time.Instant;
import java.util.Optional;

/**
 * Created by bruenni on 29.12.16.
 */
public class TrackPoint {
        private final Double latitude;
        private final Double longitude;
        private final Double altitude;
        private final Optional<Instant> time;

        /**
         * Defines track point
         * @param latitude  - latitude in degrees
         * @param longitude - longitude in degrees
         * @param altitude  - altitude in meters
         * @param time      - time point is registered
         */
        public TrackPoint(final Double latitude, final Double longitude, final Double altitude, final Optional<Instant> time) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.altitude = altitude;

            this.time = time;
        }

        public TrackPoint(double maxLatitude, double minLongitude) {
            latitude = maxLatitude;
            longitude = minLongitude;
            this.altitude = null;

            this.time = null;
        }

    @Override
    public String toString() {
        return String.format("[lat=%1s, long=%2s, alt=%3s, time=%4s]", this.getLatitude(), this.getLongitude(), this.getAltitude(), this.getTime());
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TrackPoint that = (TrackPoint) o;

            if (altitude != null ? !altitude.equals(that.altitude) : that.altitude != null) return false;
            if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
            if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
            if (time != null ? !time.equals(that.time) : that.time != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = latitude != null ? latitude.hashCode() : 0;
            result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
            result = 31 * result + (altitude != null ? altitude.hashCode() : 0);
            result = 31 * result + (time != null ? time.hashCode() : 0);
            return result;
        }

        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public Optional<Instant> getTime() {
            return time;
        }

        public Double getAltitude() {
            return altitude;
        }
}
