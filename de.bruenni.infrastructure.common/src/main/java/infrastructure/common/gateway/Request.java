package infrastructure.common.gateway;

import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public abstract class Request<TId> extends AsyncRequestBase<TId> {

    public Request(TId correlationId) {
        super(correlationId);
    }

}
