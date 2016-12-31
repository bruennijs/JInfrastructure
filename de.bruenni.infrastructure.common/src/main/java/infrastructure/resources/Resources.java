package infrastructure.resources;

import java.io.InputStream;

/**
 * Created by bruenni on 30.12.16.
 */
public class Resources {
    /**
     * reads resource by name.
     * @param name
     */
    public static InputStream getResourceAsStream(String name)
    {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader.getResourceAsStream(name);
    }
}
