package infrastructure.web.client;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BasicAuthorizationInterceptor implements ClientHttpRequestInterceptor {

    private final String username;

    private final String password;

    BasicAuthorizationInterceptor(String username, String password) {
        this.username = username;
        this.password = (password == null ? "" : password);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        String token = Base64Utils.encodeToString(
                (this.username + ":" + this.password).getBytes(StandardCharsets.UTF_8));
        request.getHeaders().add("Authorization", "Basic " + token);
        return execution.execute(request, body);
    }

}