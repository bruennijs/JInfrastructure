import infrastructure.common.gateway.RequestResult;
import infrastructure.common.gateway.Response;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.UUID;

class TestReponse extends Response<UUID> {

    public TestReponse(UUID correlationId) {
        super(correlationId);
    }
}

class TestRequestResult extends RequestResult<UUID, Boolean> {

    public TestRequestResult(UUID correlationId, Boolean aBoolean) {
        super(correlationId, aBoolean);
    }
}

/**
 * Created by bruenni on 25.06.16.
 */
public class RequestResponseTests {
    @Test
    public void when_response_from_concrete_type_expect_type_return_from_getter() throws Exception {
        TestReponse testReponse = new TestReponse(UUID.randomUUID());
        Assert.isInstanceOf(UUID.class, testReponse.getCorrelationId());
    }

    @Test
    public void when_reqresult_expect_getter_expected_type() throws Exception {

        TestRequestResult testRequestResult = new TestRequestResult(UUID.randomUUID(), true);
        Assert.isInstanceOf(UUID.class, testRequestResult.getCorrelationId());

    }
}
