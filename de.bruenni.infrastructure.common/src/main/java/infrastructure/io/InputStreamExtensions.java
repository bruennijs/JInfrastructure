package infrastructure.io;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by bruenni on 30.12.16.
 */
public class InputStreamExtensions {
    public static String readAsString(InputStream input)
    {
        return readAsString(input, "utf-8");
    }

    public static String readAsString(InputStream input, String charsetName)
    {
        return new Scanner(input, charsetName).useDelimiter("\\Z").next();
    }
}
