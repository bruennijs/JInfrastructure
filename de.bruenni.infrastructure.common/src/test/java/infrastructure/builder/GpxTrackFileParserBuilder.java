package infrastructure.builder;

import infrastructure.tracking.file.gpx.GpxTrackFileParser;

/**
 * Created by bruenni on 30.12.16.
 */
public class GpxTrackFileParserBuilder {
    public GpxTrackFileParser build() {
        return new GpxTrackFileParser();
    }
}
