package infrastructure.tracking.file;

import javax.xml.bind.JAXBException;

/**
 * Created by bruenni on 29.12.16.
 * Thrown with implementation specific inner exception
 */
public class TrackFileParserException extends Exception {
    private String path;

    /**
     * Constructor
     * @param message
     * @param path
     * @param cause
     */
    public TrackFileParserException(String message, String path, Throwable cause) {
        super(message, cause);
        this.path = path;
    }

    public TrackFileParserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Gets the file path.
     * @return
     */
    public String getPath() {
        return path;
    }
}
