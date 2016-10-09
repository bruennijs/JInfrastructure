package infrastructure.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by bruenni on 08.10.16.
 */
public class IterableUtils {
    /**
     * Converts to ArrayList.
     * @param iterable
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(final Iterable<T> iterable)
    {
        return stream(iterable).collect(Collectors.toList());
    }

    /**
     * Non parallel stream.
     * @param iterable
     * @param <T>
     * @return
     */
    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
