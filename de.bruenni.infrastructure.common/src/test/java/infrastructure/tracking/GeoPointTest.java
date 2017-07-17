package infrastructure.tracking;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/**
 * Created by bruenni on 15.07.17.
 */
@RunWith(JUnit4.class)
public class GeoPointTest {
    @Test
    public void when_parse_happy_path_expect_bigdecimal_correct() throws Exception {
        GeoPointBD coordinate = GeoPointBD.parse("53.153121, 8.229314");

        Assert.assertThat(coordinate.getLatitude(), IsEqual.equalTo(BigDecimal.valueOf(53153121, 6)));
        Assert.assertThat(coordinate.getLongitude(), IsEqual.equalTo(BigDecimal.valueOf(8229314, 6)));
    }
}
