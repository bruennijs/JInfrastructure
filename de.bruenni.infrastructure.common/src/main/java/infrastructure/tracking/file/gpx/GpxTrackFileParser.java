package infrastructure.tracking.file.gpx;

import infrastructure.parser.IDtoParser;
import infrastructure.parser.JaxbParser;
import infrastructure.parser.ParserException;
import infrastructure.tracking.Track;
import infrastructure.tracking.file.ITrackFileParser;
import infrastructure.tracking.file.TrackFileParserException;
import infrastructure.tracking.file.gpx.jaxb.GpxType;
import infrastructure.tracking.file.gpx.jaxb.TrkType;
import infrastructure.tracking.file.gpx.jaxb.WptType;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by bruenni on 29.12.16.
 */
public class GpxTrackFileParser implements ITrackFileParser {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(GpxTrackFileParser.class);

    private static IDtoParser jaxbParser = new JaxbParser();

    @Override
    public Iterable<Track> parse(InputStream input) throws TrackFileParserException {
        try {
            //JAXBContext context = JAXBContext.newInstance("infrastructure.tracking.file.gpx.jaxb");
            GpxType gpxRoot = this.jaxbParser.parse(input, GpxType.class);

            return convertToDomainObject(gpxRoot);
        } catch (ParserException e) {
            log.error("Could create and parse GPX file", e);
            throw new TrackFileParserException("Could create and parse GPX file", e);
        }
    }

    private Iterable<Track> convertToDomainObject(GpxType gpxType) {

        ArrayList<Track> trackList = new ArrayList();

        for (TrkType trkType : gpxType.getTrk())
        {
            List<WptType> waypointsOfAllSegments = reduceWaypointsOfAllSegments(trkType);

            GpxJaxbTypeConverter.toTrack(trkType, waypointsOfAllSegments.stream().map(GpxJaxbTypeConverter::toTrackPoint).collect(Collectors.toList()));
        }

        return trackList;
    }

    /**
     * Reduces all segment's track points to flat list of waypoints
     * @param trkType
     * @return
     */
    private List<WptType> reduceWaypointsOfAllSegments(TrkType trkType) {
        List<WptType> pointsOfAllSegments = new ArrayList();

        trkType.getTrkseg().stream().reduce(pointsOfAllSegments, (accumulated, trkseg) -> {
            trkseg.getTrkpt().stream().forEach(pointsOfAllSegments::add);
            return accumulated;

        }, (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        });

        return pointsOfAllSegments;
    }
}
