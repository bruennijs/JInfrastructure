package infrastructure.common.gateway;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public class RequestResult<TCorrelationId extends Serializable, TResult> extends AsyncRequestBase<TCorrelationId> {

    private TResult result;
    private String reason;

    public RequestResult(TCorrelationId correlationId, TResult result) {
        super(correlationId);
        this.result = result;
    }

    public RequestResult(TCorrelationId correlationId, TResult result, String message) {
        this(correlationId, result);
        reason = message;
    }

    /**
     * Gets the result object
     * @return
     */
    public TResult getResult() {
        return result;
    }

    /**
     * Gets the reason in case of not successful.
     * @return
     */
    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "result=" + result +
                ", reason='" + reason + '\'' +
                "} " + super.toString();
    }
}
