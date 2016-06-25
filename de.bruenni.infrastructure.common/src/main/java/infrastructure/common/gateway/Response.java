package infrastructure.common.gateway;

import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public abstract class Response<TId> extends AsyncRequestBase<TId> {

    public Response(TId correlationId) {
        super(correlationId);
    }


}
