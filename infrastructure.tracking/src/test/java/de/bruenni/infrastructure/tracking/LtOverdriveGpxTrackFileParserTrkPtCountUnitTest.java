package de.bruenni.infrastructure.tracking;

import de.bruenni.infrastructure.tracking.builder.LtOverdriveGpxTrackFileParserBuilder;
import de.bruenni.infrastructure.tracking.file.LtOverdriveGpxTrackFileParser;
import infrastructure.resources.Resources;
import infrastructure.tracking.Track;
import infrastructure.util.IterableUtils;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by bruenni on 29.12.16.
 */
@RunWith(Parameterized.class)
public class LtOverdriveGpxTrackFileParserTrkPtCountUnitTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"gpx/2tracks.gpx", "Vaidas Pilkauskas", 2, 7},
                {"gpx/Berg-Land_Tour1.gpx", "Berg-Land_Tour1", 1, 2510},
                {"gpx/one_trk_two_trkpt.gpx", "one_trk_two_trkpt",1,  2},
        });
    }

    @Parameterized.Parameter(value = 0)
    public String gpxResourcePath;

    @Parameterized.Parameter(value = 1)
    public String expectedtrkName;

    @Parameterized.Parameter(value = 2)
    public long expectedTrkCount;

    @Parameterized.Parameter(value = 3)
    public long expectedtrkptcount;


    @Test
    public void when_parse_valid_gpx_expect_name_and_trkpt_count_correct() throws Exception {
        try (InputStream gpxInputStream = loadGpxFile(gpxResourcePath)) {

            LtOverdriveGpxTrackFileParser sut = new LtOverdriveGpxTrackFileParserBuilder().build();
            Iterable<Track> tracksIterable = sut.parse(gpxInputStream);

            List<Track> tracks = IterableUtils.toList(tracksIterable);

            Assert.assertThat(tracks.size(), new IsEqual((int) expectedTrkCount));

            Optional<Track> track = tracks.stream().findFirst();

            Assert.assertThat(track.get().getName(), new IsEqual(expectedtrkName));
            Assert.assertThat(IterableUtils.stream(track.get().getPoints()).count(), new IsEqual(expectedtrkptcount));
        }
    }

    private InputStream loadGpxFile(String name) {
        return Resources.getResourceAsStream(name);
    }
}
