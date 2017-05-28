package infrastructure.common.event.test;

import infrastructure.common.event.Event;
import infrastructure.common.event.implementation.DomainEventBusImpl;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * Created by bruenni on 30.04.16.
 */
public class DomainEventBusTests {
    @Test
    public void When_subscribe_and_event_fired_expected_observer_called() {
        Event event = new MyEvent(UUID.randomUUID());

        DomainEventBusImpl sut = new DomainEventBusImpl();
        Observable<Event> onEvent = sut.subscribe().timeout(10, TimeUnit.MILLISECONDS).take(1);

        sut.publish(event);

        Event evented = onEvent.toBlocking().single();
        Assert.assertEquals(event.getId(), evented.getId());
    }
}
