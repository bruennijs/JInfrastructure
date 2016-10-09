package infrastructure.common.extensions;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by bruenni on 09.10.16.
 */
public class ZonedDateTimeExtensionsTest {
    @Test
    public void date_experiments()
    {
        // current (local) time in Los Angeles
        //LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));


        LocalDateTime nowDefault = LocalDateTime.now(java.time.Clock.systemDefaultZone());
        LocalDateTime nowInUtc = LocalDateTime.now(java.time.Clock.systemUTC());

        System.out.println("nowDefault" + nowDefault.toString());
        System.out.println("nowInUtc" + nowInUtc.toString());

        LocalDateTime ldt = LocalDateTime.of(2016, 10, 31, 23, 59, 59);
        Instant instant = ldt.toInstant(ZoneOffset.UTC);
    }

    @Test
    public void when_parse_from_zoned_string_expect_localdatetime_normalized()
    {
        String iso8601TimeStamp = "2016-10-31T20:59:59Z";
        String timeZonePlus2TimeStamp = "2016-10-31T22:59:59+02:00";

        LocalDateTime ldtIso8601 = LocalDateTime.parse(iso8601TimeStamp, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime ldtPlus2 = LocalDateTime.parse(timeZonePlus2TimeStamp, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        Assert.assertNotEquals(ldtIso8601, ldtPlus2);
    }

    @Test
    public void when_parse_from_zoned_string_expect_zoneddatetime_converts_to_normalized_localdatetime()
    {
        String timeZonePlus2TimeStamp = "2016-10-31T22:59:59+02:00";

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(timeZonePlus2TimeStamp);
        LocalDateTime ldtUtc = LocalDateTime.of(2016, 10, 31, 20, 59, 59);


        Assert.assertNotEquals(ldtUtc, zonedDateTime.toLocalDateTime());
    }

    @Test
    public void when_parse_from_zoned_string_expect_zonzoneddatetime_can_convert_to_utc()
    {
        String timeZonePlus2TimeStamp = "2016-10-31T22:59:59+02:00";

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(timeZonePlus2TimeStamp);
        LocalDateTime ldtUtc = LocalDateTime.of(2016, 10, 31, 20, 59, 59);

        Assert.assertEquals(ldtUtc, zonedDateTime.withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime());
    }


    @Test
    public void localdatetime_and_instant_compare()
    {
        String iso8601TimeStamp = "2016-10-31T20:59:59Z";
        LocalDateTime ldtFromNumeric = LocalDateTime.of(2016, 10, 31, 20, 59, 59);
        LocalDateTime ldtFromString = LocalDateTime.parse(iso8601TimeStamp, DateTimeFormatter.ISO_DATE_TIME);
        Instant instantNum = ldtFromNumeric.toInstant(ZoneOffset.UTC);
        Instant instantString = ldtFromString.toInstant(ZoneOffset.UTC);

        Instant instantParsed = Instant.parse(iso8601TimeStamp);

        Assert.assertEquals(instantNum, instantString);
        Assert.assertEquals(instantNum, instantParsed);

    }

    @Test
    public void When_parse_zonedtimezone_from_expect()
    {
        Instant instant = Instant.ofEpochSecond(1475923152);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));

        Assert.assertEquals("2016-10-08T10:39:12Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
    }

    @Test
    public void time()
    {
        System.out.println(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(1475563957000l)).toString());
        System.out.println(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(1475563987000l)).toString());
        System.out.println(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(1475609546000l)).toString());

    }
}
