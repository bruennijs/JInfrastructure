package infrastructure.identity.implementation;

import infrastructure.identity.AuthenticationFailedException;
import infrastructure.identity.ITokenAuthentication;
import infrastructure.identity.Token;
import io.jsonwebtoken.*;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Map;

/**
 * Created by bruenni on 15.10.16.
 * https://www.jsonwebtoken.io/
 */
public abstract class AbstractJJwtTokenAuthentication implements ITokenAuthentication {


    @Override
    public infrastructure.identity.Jwt verify(Token token) throws AuthenticationFailedException {
        try
        {
            Jws<Claims> claimsJws = this.getParser().parseClaimsJws(token.getValue());

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

    protected abstract JwtParser getParser();

    @Override
    public Token create(infrastructure.identity.Jwt jwt) {
        String jwtString = this.getBuilder()
                .setClaims(jwt.getClaims())
                .setSubject(jwt.getSubject())
                .setIssuedAt(jwt.getIat())
                .setExpiration(jwt.getExp())
                .compact();

        return Token.valueOf(jwtString);
    }

    protected abstract JwtBuilder getBuilder();
}
