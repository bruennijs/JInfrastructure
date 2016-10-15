package infrastructure.identity;

import infrastructure.identity.implementation.JJwtTokenAuthenticationFactory;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.PublicKey;
import java.sql.Date;
import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruenni on 15.10.16.
 */
@RunWith(JUnit4.class)
public class JJwtTokenAuthenticationTest {

    private final List<ITokenAuthentication> tokenAuthenticationList;

    public JJwtTokenAuthenticationTest() {
        this.tokenAuthenticationList = Arrays.asList(JJwtTokenAuthenticationFactory.createWithoutSign(), JJwtTokenAuthenticationFactory.createAsymmetric(SignatureAlgorithm.RS512, 4096));
    }

    @Test
    public void When_create_with_two_claims_expect_token_verifies_by_invers_operation() throws AuthenticationFailedException {
        for (ITokenAuthentication sut : this.tokenAuthenticationList) {

            HashMap claimsMap = new HashMap();

            String groupsValue = "oldenburgerradsportfreunde, test";
            String groupsKey = "groups";
            claimsMap.put(groupsKey, groupsValue);
            String subject = "bruenni";

            Instant iat = Instant.now(Clock.systemUTC());
            Instant exp = iat.plusSeconds(100);


            Jwt jwt = new Jwt(subject, Date.from(iat), Date.from(exp), claimsMap);

            Token token = sut.create(jwt);

            Jwt jwtParsed = sut.verify(token);
            Assert.assertEquals(groupsValue, jwtParsed.getClaims().get(groupsKey));
            Assert.assertEquals(subject, jwtParsed.getSubject());
        }
    }

    @Test
    public void When_create_with_expiration_before_now_expect_AuthenticationFailedException() {
        ITokenAuthentication sut = JJwtTokenAuthenticationFactory.createAsymmetric(SignatureAlgorithm.RS512, 4096);

        HashMap claimsMap = new HashMap();

        Instant iat = Instant.now(Clock.systemUTC());
        Instant exp = iat.minusSeconds(100);


        Jwt jwt = new Jwt("", Date.from(iat), Date.from(exp), claimsMap);

        Token token = sut.create(jwt);

        try {
            sut.verify(token);
            Assert.fail("Must throw exception");
        }
        catch (AuthenticationFailedException exc)
        {
        }
    }
}
