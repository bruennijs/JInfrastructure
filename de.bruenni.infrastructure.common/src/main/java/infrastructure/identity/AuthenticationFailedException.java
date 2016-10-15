package infrastructure.identity;

import io.jsonwebtoken.SignatureException;

/**
 * Created by bruenni on 15.10.16.
 * Identity of token not trusted.
 */
public class AuthenticationFailedException extends Exception {
    /**
     * Constructor
     * @param message
     * @param sigException
     */
    public AuthenticationFailedException(String message, SignatureException sigException) {
        super(message, sigException);
    }
}
