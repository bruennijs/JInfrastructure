package infrastructure.parser;

/**
 * Created by bruenni on 31.12.16.
 */
public class ParserException extends Exception {
    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserException(String message) {
        super(message);
    }
}
