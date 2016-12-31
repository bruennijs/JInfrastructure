package infrastructure.tracking.file;

import infrastructure.tracking.Track;

import java.io.File;
import java.io.InputStream;

/**
 * Created by bruenni on 29.12.16.
 * generic track file parser. See implementations for file types.
 * By default GPX and TCX are supported.
 */
public interface ITrackFileParser {
    /**
     * Parses a track input of
     * @param input
     * @return
     * @throws TrackFileParserException
     */
    Iterable<Track> parse(InputStream input) throws TrackFileParserException;
}
