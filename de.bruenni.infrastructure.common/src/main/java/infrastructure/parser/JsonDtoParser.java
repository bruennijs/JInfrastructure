package infrastructure.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bruenni on 28.08.16.
 */
public class JsonDtoParser implements IDtoParser {
    private final ObjectMapper jsonMapper;

    public JsonDtoParser() {
        this.jsonMapper = new ObjectMapper();
    }

    /**
     * Serializes object to json.
     * @param object
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public <T> String serialize(T object) throws SerializingException {
        try {
            return this.jsonMapper.writeValueAsString(object);
        }
        catch (Exception exc)
        {
            throw new SerializingException("Serialization of object [type=" + object.getClass() + "] failede", exc);
        }
    }

    /**
     * Parses dto string to POJO instance.
     * @param dto
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> T parse(String dto, Class<T> type) throws ParserException {
        try {
            return (T)this.jsonMapper.readValue(dto, type);
        } catch (IOException e) {
            throw new ParserException("Parsing of object [type=" + type + "] failed", e);
        }
    }

    @Override
    public <T> T parse(byte[] dto, Class<T> type) throws ParserException {
        try {
            return (T)this.jsonMapper.readValue(dto, type);
        } catch (IOException e) {
            throw new ParserException("Parsing of object [type=" + type + "] failed", e);
        }
    }

    @Override
    public <T> T parse(InputStream input, Class<T> type) throws ParserException {
        throw new ParserException("Not supported");
    }

    protected ObjectMapper getJsonMapper() {
        return jsonMapper;
    }
}
