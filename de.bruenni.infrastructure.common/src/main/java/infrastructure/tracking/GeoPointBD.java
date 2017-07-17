package infrastructure.tracking;

import java.math.BigDecimal;

/**
 * Created by bruenni on 15.07.17.
 */
public class GeoPointBD extends GeoPoint<BigDecimal> {
    /**
     * Constructor
     *
     * @param latitude
     * @param longitude
     */
    public GeoPointBD(BigDecimal latitude, BigDecimal longitude) {
        super(latitude, longitude);
    }

    /**
     * Parse from format: '53.153121, 8.229314'
     * @param value
     * @return
     */
    public static GeoPointBD parse(String value) throws Exception {
        String[] tokens = value.split(",", 2);

        if (tokens == null || tokens.length != 2)
        {
            throw new Exception("not two tokens seperated by ','");
        }

        return new GeoPointBD(new BigDecimal(tokens[0].trim()), new BigDecimal(tokens[1].trim()));
    }

    /**
     * To double geopoint
     * @return
     */
    public GeoPoint<Double> toDouble()
    {
        return new GeoPointDouble(getLatitude().doubleValue(), getLongitude().doubleValue());
    }
}
