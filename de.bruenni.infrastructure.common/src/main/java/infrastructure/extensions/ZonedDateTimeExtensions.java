package infrastructure.extensions;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by bruenni on 09.10.16.
 */
public class ZonedDateTimeExtensions {
    /**
     * Converts to object where timezone is set to 'UTC'
     * @param me
     * @return
     */
    public static ZonedDateTime toUtc(ZonedDateTime me)
    {
        return me.withZoneSameInstant(ZoneId.of("UTC"));
    }

    /***
     * formats to 'yyyy-mm-ddThh:mm:ss:SSSSSZ'
     * @param me
     * @return
     */
    public static String toIso9601ZeroString(ZonedDateTime me)
    {
        return me.format(DateTimeFormatter.ISO_INSTANT);
    }

    /***
     * Asumes instant is in UTC and loads instant and sets the timezone UTC i
     * in ZonedDateTime.
     * @param instant
     * @return
     */
    public static ZonedDateTime ofUtcInstant(Instant instant)
    {
        return ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }
}
