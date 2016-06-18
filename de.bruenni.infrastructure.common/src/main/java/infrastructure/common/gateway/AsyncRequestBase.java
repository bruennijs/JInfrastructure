package infrastructure.common.gateway;

import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public abstract class AsyncRequestBase<TId> {
    public TId correlationId;

    public AsyncRequestBase(TId correlationId) {
        this.correlationId = correlationId;
    }

    public TId getCorrelationId() {
        return correlationId;
    }
}
