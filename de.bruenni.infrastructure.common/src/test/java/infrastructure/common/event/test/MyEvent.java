package infrastructure.common.event.test;

import infrastructure.common.event.implementation.Event;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public class MyEvent extends Event {
    public MyEvent(UUID aggregateId) {
        super(aggregateId);
    }

    public MyEvent(UUID id, UUID aggregateId, Date timestamp) {
        super(id, aggregateId, timestamp);
    }
}
