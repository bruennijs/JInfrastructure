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
    Map<String, Object> verify(Token token) throws AuthenticationFailedException;

    /**
     * creates a signed and encoded token with claims.
     * @param subject subject of token
     * @param claims claims to set.
     * @return
     */
    Token create(String subject, Map<String, Object> claims);
}
