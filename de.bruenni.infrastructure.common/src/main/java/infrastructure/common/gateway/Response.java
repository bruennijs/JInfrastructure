package infrastructure.common.gateway;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public abstract class Response<TCorrelationId extends Serializable> extends AsyncRequestBase<TCorrelationId> {

    public Response(TCorrelationId correlationId) {
        super(correlationId);
    }

    @Override
    public String toString() {
        return "Response{} " + super.toString();
    }
}
