package infrastructure.parser;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bruenni on 28.08.16.
 */
public interface IDtoParser {
    <T> String serialize(T object) throws SerializingException;

    <T> T parse(String dto, Class<T> type) throws ParserException;

    <T> T parse(byte[] dto, Class<T> type) throws ParserException;

    <T> T parse(InputStream input, Class<T> type) throws ParserException;
}
