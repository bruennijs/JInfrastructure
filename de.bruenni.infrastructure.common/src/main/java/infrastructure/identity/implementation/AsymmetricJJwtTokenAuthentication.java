package infrastructure.identity.implementation;

import infrastructure.identity.AuthenticationFailedException;
import infrastructure.identity.ITokenAuthentication;
import infrastructure.identity.Token;
import io.jsonwebtoken.*;
import org.springframework.util.StreamUtils;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Date;
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
    public infrastructure.identity.Jwt verify(Token token) throws AuthenticationFailedException {
        try
        {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(token.getValue());

            Claims body = claimsJws.getBody();

            Map<String, Object> claimsMap = infrastructure.util.StreamUtils.toMap(claimsJws.getBody().entrySet().stream());

            return new infrastructure.identity.Jwt(body.getSubject(), body.getIssuedAt(), body.getExpiration(), claimsMap);
        }
        catch (SignatureException sigException)
        {
            throw new AuthenticationFailedException("Signature invalid [" + token.getValue() + ", " + sigException.getMessage() + "]", sigException);
        }
        catch (ExpiredJwtException expiredException)
        {
            throw new AuthenticationFailedException("expiration date is less than now", expiredException);
        }
    }

    @Override
    public Token create(infrastructure.identity.Jwt jwt) {
        String jwtString = Jwts.builder()
                .signWith(this.algorithm, this.keyPair.getPrivate())
                .setClaims(jwt.getClaims())
                .setSubject(jwt.getSubject())
                .setIssuedAt(jwt.getIat())
                .setExpiration(jwt.getExp())
                .compact();

        return Token.valueOf(jwtString);
    }
}
