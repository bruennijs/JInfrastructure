package de.bruenni.infrastructure.tracking.file;

import infrastructure.tracking.GeoPoint;
import infrastructure.tracking.Track;
import infrastructure.tracking.file.ITrackFileParser;
import infrastructure.tracking.file.TrackFileParserException;
import lt.overdrive.trackparser.domain.TrackPoint;
import lt.overdrive.trackparser.domain.Trail;
import lt.overdrive.trackparser.parsing.GpsFileParser;
import lt.overdrive.trackparser.parsing.ParserException;
import org.joda.time.DateTime;

import java.io.InputStream;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by bruenni on 05.01.17.
 */
public class LtOverdriveGpxTrackFileParser implements ITrackFileParser {

    private GpsFileParser parser = new lt.overdrive.trackparser.parsing.gpx.GpxParser();

    /**
     * Parses GPX files.
     * @param inputStream
     * @return
     * @throws TrackFileParserException
     */
    public Iterable<Track> parse(InputStream inputStream) throws TrackFileParserException {
        Trail trail = null;
        try {
            trail = parser.parse(inputStream);
            return trail.getTracks().stream().map(t -> toTrack(t)).collect(Collectors.toList());
        } catch (ParserException e) {
            throw new TrackFileParserException("Could not parse GPX file by InputStream", e);
        }
    }

    private Track toTrack(lt.overdrive.trackparser.domain.Track ltOverdriveTrack) {
        return new Track(ltOverdriveTrack.getName(), ltOverdriveTrack.getDesc(), ltOverdriveTrack.getPoints().stream().map(tp -> toTrackPoint(tp)).collect(Collectors.toList()));
    }

    private infrastructure.tracking.TrackPoint toTrackPoint(TrackPoint trackPoint) {

        DateTime timestamp = trackPoint.getTime();

        return new infrastructure.tracking.TrackPoint(
            new GeoPoint(trackPoint.getLatitude(),trackPoint.getLongitude()),
                trackPoint.getAltitude(),
                Optional.ofNullable(timestamp != null ? Instant.ofEpochMilli(timestamp.toInstant().getMillis()) : null));
    }
}
