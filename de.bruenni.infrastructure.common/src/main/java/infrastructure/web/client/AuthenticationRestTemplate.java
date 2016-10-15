package infrastructure.web.client;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created by bruenni on 12.10.16.
 */
public class AuthenticationRestTemplate extends RestTemplate {
    /***
     * Add basic authentication.
     * @param userName
     * @param password
     */
    public AuthenticationRestTemplate addBasicAuthentication(String userName, String password)
    {
        if (userName == null) {
            return null;
        }
        List<ClientHttpRequestInterceptor> interceptors = Collections
                .<ClientHttpRequestInterceptor> singletonList(new BasicAuthorizationInterceptor(
                        userName, password));
        setRequestFactory(new InterceptingClientHttpRequestFactory(getRequestFactory(),
                interceptors));
        return this;
    }
}
