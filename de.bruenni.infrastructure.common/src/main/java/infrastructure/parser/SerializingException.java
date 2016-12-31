package infrastructure.parser;

/**
 * Created by bruenni on 31.12.16.
 */
public class SerializingException extends Exception {
    public SerializingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializingException(String message) {
        super(message);
    }
}
