package infrastructure.common.event.test;

import infrastructure.common.event.implementation.DomainEventBusImpl;
import infrastructure.common.event.implementation.Event;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by bruenni on 30.04.16.
 */
public class DomainEventBusTests {
    @Test
    public void When_subscribe_and_event_fired_expected_observer_called() {
        Event event = new Event("1");

        DomainEventBusImpl<Event> sut = new DomainEventBusImpl<Event>();
        Observable<Event> onEvent = sut.subscribe().timeout(10, TimeUnit.MILLISECONDS).take(1);

        sut.publish(event);

        Event evented = onEvent.toBlocking().single();
        Assert.assertEquals(event.getId(), evented.getId());
    }
}
