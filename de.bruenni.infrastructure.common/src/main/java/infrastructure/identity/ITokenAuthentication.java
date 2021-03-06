package infrastructure.identity;

import java.util.Map;

/**
 * Created by bruenni on 15.10.16.
 */
public interface ITokenAuthentication {
    /**
     * Authenticates and retrieves claims.
     * @param token
     * @return claims extracted from token.
     */
    Jwt verify(Token token) throws AuthenticationFailedException;

    /**
     * creates a signed and encoded token with claims.
     * @param jwt json web token data
     * @return
     */
    Token create(Jwt jwt);
}
