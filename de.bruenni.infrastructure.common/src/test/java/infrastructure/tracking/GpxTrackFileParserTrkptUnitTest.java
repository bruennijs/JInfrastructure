package infrastructure.tracking;

import infrastructure.builder.GpxTrackFileParserBuilder;
import infrastructure.resources.Resources;
import infrastructure.tracking.file.gpx.GpxTrackFileParser;
import infrastructure.util.IterableUtils;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;
import java.time.Instant;
import java.util.stream.Stream;

/**
 * Created by bruenni on 29.12.16.
 */
@RunWith(JUnit4.class)
public class GpxTrackFileParserTrkptUnitTest {

    @Test
    public void when_parse_gpx_expect_trkpt_contains_expected_values() throws Exception {

        Instant expectedTimestamp = Instant.parse("2010-07-24T07:18:09Z");

        try (InputStream gpxInputStream = loadGpxFile()) {

            GpxTrackFileParser sut = new GpxTrackFileParserBuilder().build();
            Iterable<Track> tracks = sut.parse(gpxInputStream);

            Track track = IterableUtils.stream(tracks).findFirst().get();
            Stream<TrackPoint> pointsStream = IterableUtils.stream(track.getPoints()).filter(p -> p.getTime().equals(expectedTimestamp));

            Assert.assertThat(pointsStream.count(), new IsEqual(1));

            TrackPoint trackPoint = pointsStream.findFirst().get();

            Assert.assertThat(trackPoint.getLatitude(), new IsEqual(51.11779700d));
            Assert.assertThat(trackPoint.getLongitude(), new IsEqual<>(7.39852000d));
            Assert.assertThat(trackPoint.getAltitude(), new IsEqual<>(276.51635700));
            Assert.assertThat(trackPoint.getTime(), new IsEqual<>(expectedTimestamp));
        }
    }

    private InputStream loadGpxFile() {
        return Resources.getResourceAsStream("gpx/Berg-Land_Tour1.gpx");
    }
}
