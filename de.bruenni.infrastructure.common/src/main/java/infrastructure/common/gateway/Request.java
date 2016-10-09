package infrastructure.common.gateway;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public abstract class Request<TCorrelationId extends Serializable> extends AsyncRequestBase<TCorrelationId> {

    public Request(TCorrelationId correlationId) {
        super(correlationId);
    }

}
