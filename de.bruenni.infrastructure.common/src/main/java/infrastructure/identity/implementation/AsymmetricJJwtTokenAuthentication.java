package infrastructure.identity.implementation;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.KeyPair;
import java.security.PublicKey;

/**
 * Created by bruenni on 15.10.16.
 * https://www.jsonwebtoken.io/
 */
public class AsymmetricJJwtTokenAuthentication extends AbstractJJwtTokenAuthentication {

    private SignatureAlgorithm algorithm;
    private KeyPair keyPair;
    private PublicKey publicKey;

    /**
     * For signing and verifying.
     * @param algorithm
     * @param keyPair
     */
    public AsymmetricJJwtTokenAuthentication(SignatureAlgorithm algorithm, KeyPair keyPair) {
        this.algorithm = algorithm;
        this.keyPair = keyPair;
        this.publicKey = keyPair.getPublic();
    }

    /**
     * Just for verifying.
     * @param publicKey
     */
    public AsymmetricJJwtTokenAuthentication(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    protected JwtParser getParser() {
        return Jwts.parser().setSigningKey(this.publicKey);
    }

    @Override
    protected JwtBuilder getBuilder() {
        return Jwts.builder()
                .signWith(this.algorithm, this.keyPair.getPrivate());
    }
}
