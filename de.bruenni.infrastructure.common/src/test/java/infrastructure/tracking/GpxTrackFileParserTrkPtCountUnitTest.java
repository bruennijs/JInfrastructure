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
import org.junit.runners.Parameterized;

import java.io.InputStream;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by bruenni on 29.12.16.
 */
@RunWith(Parameterized.class)
public class GpxTrackFileParserTrkPtCountUnitTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"gpx/Berg-Land_Tour1.gpx", "Berg-Land_Tour1", 2540},
                {"gpx/one_trk_two_trkpt.gpx", "one_trk_two_trkpt", 2},
        });
    }

    @Parameterized.Parameter(value = 0)
    public String gpxResourcePath;

    @Parameterized.Parameter(value = 1)
    public String expectedtrkName;

    @Parameterized.Parameter(value = 2)
    public int expectedtrkptcount;


    @Test
    public void when_parse_valid_gpx_expect_name_and_trkpt_count_correct() throws Exception {
        try (InputStream gpxInputStream = loadGpxFile(gpxResourcePath)) {

            GpxTrackFileParser sut = new GpxTrackFileParserBuilder().build();
            Iterable<Track> tracks = sut.parse(gpxInputStream);

            Stream<Track> trackStream = IterableUtils.stream(tracks);

            Assert.assertThat(trackStream.count(), new IsEqual(1));

            Optional<Track> track = trackStream.findFirst();

            Assert.assertThat(track.get().getName(), new IsEqual(expectedtrkName));
            Assert.assertThat(IterableUtils.stream(track.get().getPoints()).count(), new IsEqual(expectedtrkptcount));
        }
    }

    private InputStream loadGpxFile(String name) {
        return Resources.getResourceAsStream(name);
    }
}
