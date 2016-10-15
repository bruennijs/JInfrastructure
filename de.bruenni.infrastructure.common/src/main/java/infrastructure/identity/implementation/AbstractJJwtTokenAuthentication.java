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
            Claims claims = this.getBody(token);

            Map<String, Object> claimsMap = infrastructure.util.StreamUtils.toMap(claims.entrySet().stream());

            return new infrastructure.identity.Jwt(claims.getSubject(), claims.getIssuedAt(), claims.getExpiration(), claimsMap);
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

    protected abstract Claims getBody(Token token);

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
