package infrastructure.tracking.file.gpx;

import infrastructure.tracking.Track;
import infrastructure.tracking.TrackPoint;
import infrastructure.tracking.file.gpx.jaxb.TrkType;
import infrastructure.tracking.file.gpx.jaxb.WptType;

import java.time.Instant;
import java.util.Optional;

/**
 * Created by bruenni on 30.12.16.
 */
public class GpxJaxbTypeConverter {
    /**
     * Converts trkType to domain model
     * @param trkType
     * @param points
     * @return
     */
    public static Track toTrack(TrkType trkType, Iterable<TrackPoint> points)
    {
        return new Track(trkType.getName(), trkType.getDesc(), points);
    }

    /**
     * Converts Wpttype to domain model.
     * @param wptType
     * @return
     */
    public static  TrackPoint toTrackPoint(WptType wptType) {
        Optional<Instant> timestamp = parseTime(wptType);
        return new TrackPoint(wptType.getLat().doubleValue(), wptType.getLon().doubleValue(), wptType.getEle().doubleValue(), timestamp);
    }

    private static Optional<Instant> parseTime(WptType wptType) {
        if (wptType.getTime() != null)
            return Optional.of(Instant.parse(wptType.getTime().toXMLFormat()));
        return null;
    }
}
