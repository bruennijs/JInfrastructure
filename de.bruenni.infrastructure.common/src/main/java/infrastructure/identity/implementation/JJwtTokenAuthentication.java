package infrastructure.identity.implementation;

import infrastructure.identity.Token;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.RsaProvider;

import java.security.KeyPair;
import java.security.PublicKey;

/**
 * Created by bruenni on 15.10.16.
 * https://www.jsonwebtoken.io/
 * Just for compatibility cause JJWT dies not support unsigned claims.
 */
public class JJwtTokenAuthentication extends AbstractJJwtTokenAuthentication {

    private final KeyPair keyPair;

    /**
     * Just for compatibility cause JJWT dies not support unsigned claims.
     */
    public JJwtTokenAuthentication() {
        this.keyPair = RsaProvider.generateKeyPair(4096);
    }

    @Override
    protected Claims getBody(Token token) {
        Jwt<Header, Claims> headerClaimsJwt = this.getParser().parseClaimsJwt(token.getValue());
        return headerClaimsJwt.getBody();
    }

    @Override
    protected JwtParser getParser() {
        return Jwts.parser();
    }
    @Override
    protected JwtBuilder getBuilder() {
        return Jwts.builder();
    }
}
