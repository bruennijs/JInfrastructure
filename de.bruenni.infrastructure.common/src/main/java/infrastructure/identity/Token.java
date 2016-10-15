package infrastructure.identity;

/**
 * Created by bruenni on 15.10.16.
 */
public class Token {
    private String value;

    /**
     * Constructor.
     * @param value
     */
    public Token(String value) {
        this.value = value;
    }

    /***
     * Gets the signed encoded value of the token.
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * creates from token value.
     * @param jwttoken
     * @return
     */
    public static Token valueOf(String jwttoken) {
        return new Token(jwttoken);
    }
}
