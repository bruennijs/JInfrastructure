package infrastructure.identity.implementation;

import infrastructure.identity.ITokenAuthentication;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.RsaProvider;

import java.security.KeyPair;

/**
 * Created by bruenni on 15.10.16.
 */
public class JJwtTokenAuthenticationFactory {
    /***
     * creates
     * @param algorithm
     * @param keySize
     */
    public static ITokenAuthentication createAsymmetric(SignatureAlgorithm algorithm, int keySize) {
        KeyPair keyPair = RsaProvider.generateKeyPair(4096);
        return new AsymmetricJJwtTokenAuthentication(algorithm, keyPair);
    }

}
