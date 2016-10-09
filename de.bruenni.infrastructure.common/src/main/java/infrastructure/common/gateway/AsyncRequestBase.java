package infrastructure.common.gateway;

import java.io.Serializable;

/**
 * Created by bruenni on 18.06.16.
 */
public abstract class AsyncRequestBase<TCorrelationId extends Serializable> {
    private TCorrelationId correlationId;

    /**
     * Constructor
     * @param correlationId
     */
    public AsyncRequestBase(TCorrelationId correlationId)
    {
        this.correlationId = correlationId;
    }

    /**
     * Gets the correlation id.
     * @return
     */
    public TCorrelationId getCorrelationId() {
        return correlationId;
    }

    @Override
    public String toString() {
        return "AsyncRequestBase{" +
                "correlationId=" + correlationId +
                '}';
    }
}
