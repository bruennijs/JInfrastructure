package infrastructure.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bruenni on 15.10.16.
 */
public class StreamUtils {
    /***
     * Maps from entry toMap
     * @param stream
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K, V> toMap(Stream<Map.Entry<K, V>> stream)
    {
        return stream.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }
}
