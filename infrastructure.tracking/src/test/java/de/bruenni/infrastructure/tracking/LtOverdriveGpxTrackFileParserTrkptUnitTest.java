package de.bruenni.infrastructure.tracking;

import com.google.common.collect.Lists;
import de.bruenni.infrastructure.tracking.builder.LtOverdriveGpxTrackFileParserBuilder;
import de.bruenni.infrastructure.tracking.file.LtOverdriveGpxTrackFileParser;
import infrastructure.resources.Resources;
import infrastructure.tracking.Track;
import infrastructure.tracking.TrackPoint;
import infrastructure.util.IterableUtils;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bruenni on 29.12.16.
 */
@RunWith(JUnit4.class)
public class LtOverdriveGpxTrackFileParserTrkptUnitTest {

    @Test
    public void when_parse_gpx_expect_trkpt_contains_expected_values() throws Exception {

        Instant expectedTimestamp = Instant.parse("2010-07-24T07:18:09Z");

        try (InputStream gpxInputStream = loadGpxFile()) {

            LtOverdriveGpxTrackFileParser sut = new LtOverdriveGpxTrackFileParserBuilder().build();
            Iterable<Track> tracks = sut.parse(gpxInputStream);

            Track track = IterableUtils.stream(tracks).findFirst().get();

            List<TrackPoint> matchingList = IterableUtils.stream(track.getPoints()).filter(p -> p.getTime().isPresent()).filter(tp -> tp.getTime().get().equals(expectedTimestamp)).collect(Collectors.toList());

            Assert.assertThat(matchingList.size(), new IsEqual(1));

            TrackPoint trackPoint = matchingList.get(0);

            Assert.assertThat(trackPoint.getPoint().getLatitude(), new IsEqual(51.11779700d));
            Assert.assertThat(trackPoint.getPoint().getLongitude(), new IsEqual<>(7.39852000d));
            Assert.assertThat(trackPoint.getAltitude(), new IsEqual<>(276.51635700));
            Assert.assertThat(trackPoint.getTime().get(), new IsEqual<>(expectedTimestamp));
        }
    }

    private InputStream loadGpxFile() {
        return Resources.getResourceAsStream("gpx/Berg-Land_Tour1.gpx");
    }
}
