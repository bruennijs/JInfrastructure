package infrastructure.common.event.implementation;

import infrastructure.common.event.IDomainEventBus;
import infrastructure.common.event.IEvent;
import rx.Observable;
import rx.Observer;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bruenni on 30.04.16.
 */
public class DomainEventBusImpl implements IDomainEventBus {
    private List<Observer<IEvent>> observers = new LinkedList<Observer<IEvent>>();

    /**
     * Subcribes and adds to internal list.
     * @return
     */
    public Observable<IEvent> subscribe() {
        Subject<IEvent, IEvent> subject = ReplaySubject.create();
        this.observers.add(subject);
        return subject;
    }

    /**
     * Publishes to all observers.
     * @param tEvent
     */
    public void publish(IEvent tEvent) {
        for (Observer<IEvent> o :
                this.observers) {
            o.onNext(tEvent);
        }
    }
}
