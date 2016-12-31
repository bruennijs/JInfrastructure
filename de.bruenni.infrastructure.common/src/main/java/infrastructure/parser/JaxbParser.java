package infrastructure.parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * Created by bruenni on 31.12.16.
 */
public class JaxbParser implements IDtoParser {
    @Override
    public <T> String serialize(T object) throws SerializingException {
        throw new SerializingException("not supported");
    }

    @Override
    public <T> T parse(String dto, Class<T> type) throws ParserException {
        throw new ParserException("not supported");
    }

    @Override
    public <T> T parse(byte[] dto, Class<T> type) throws ParserException {
        throw new ParserException("not supported");
    }

    @Override
    public <T> T parse(InputStream input, Class<T> type) throws ParserException {
        try {
            JAXBContext context = JAXBContext.newInstance();
            Unmarshaller unmarshaller = context.createUnmarshaller();
            //unmarshaller.setSchema(new Schema());

            JAXBElement<T> root = (JAXBElement<T>) unmarshaller.unmarshal(input);
            return root.getValue();
        } catch (JAXBException e) {
            throw new ParserException("Parsing of object [type=" + type + "] failed", e);
        }
    }
}
