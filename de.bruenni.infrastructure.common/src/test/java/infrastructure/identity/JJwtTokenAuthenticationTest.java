package infrastructure.identity;

import infrastructure.identity.implementation.JJwtTokenAuthenticationFactory;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bruenni on 15.10.16.
 */
@RunWith(JUnit4.class)
public class JJwtTokenAuthenticationTest {

    @Test
    public void When_create_with_two_claims_expect_token_verifies_by_invers_operation() throws AuthenticationFailedException {
        ITokenAuthentication sut = JJwtTokenAuthenticationFactory.createAsymmetric(SignatureAlgorithm.RS512, 4096);

        HashMap claimsMap = new HashMap();
        claimsMap.put("username", "bruenni");
        String groupsValue = "oldenburgerradsportfreunde, test";
        String groupsKey = "groups";
        claimsMap.put(groupsKey, groupsValue);
        Token token = sut.create("hello world", claimsMap);

        Map<String, Object> claimsParsed = sut.verify(token);
        Assert.assertEquals(claimsMap, claimsParsed);

        Assert.assertEquals(groupsValue, claimsParsed.get(groupsKey));
    }
}
