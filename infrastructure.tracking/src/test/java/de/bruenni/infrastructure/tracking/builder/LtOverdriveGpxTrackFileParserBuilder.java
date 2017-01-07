package de.bruenni.infrastructure.tracking.builder;

import de.bruenni.infrastructure.tracking.file.LtOverdriveGpxTrackFileParser;

/**
 * Created by bruenni on 05.01.17.
 */
public class LtOverdriveGpxTrackFileParserBuilder {
    public LtOverdriveGpxTrackFileParser build() {
        return new LtOverdriveGpxTrackFileParser();
    }
}
