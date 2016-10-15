package infrastructure.identity.implementation;

import infrastructure.identity.AuthenticationFailedException;
import infrastructure.identity.ITokenAuthentication;
import infrastructure.identity.Token;
import io.jsonwebtoken.*;
import org.springframework.util.StreamUtils;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by bruenni on 15.10.16.
 * https://www.jsonwebtoken.io/
 */
public class AsymmetricJJwtTokenAuthentication implements ITokenAuthentication {

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
    public Map<String, Object> verify(Token token) throws AuthenticationFailedException {
        try
        {
            return infrastructure.util.StreamUtils.toMap(Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(token.getValue()).getBody().entrySet().stream());
        }
        catch (SignatureException sigException)
        {
            throw new AuthenticationFailedException("Authentication failed [" + token.getValue() + ", " + sigException.getMessage() + "]", sigException);
        }
    }

    @Override
    public Token create(String  subject, Map<String, Object> claims) {
        String jwtString = Jwts.builder().setSubject(subject).signWith(this.algorithm, this.keyPair.getPrivate()).setSubject(subject).setClaims(claims).compact();
        return Token.valueOf(jwtString);
    }
}
