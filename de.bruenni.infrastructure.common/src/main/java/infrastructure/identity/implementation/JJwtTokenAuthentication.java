package infrastructure.identity.implementation;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
    protected JwtParser getParser() {
        return Jwts.parser().setSigningKey(this.keyPair.getPublic());
    }
    @Override
    protected JwtBuilder getBuilder() {
        return Jwts.builder().signWith(SignatureAlgorithm.RS512, this.keyPair.getPrivate());
    }
}
