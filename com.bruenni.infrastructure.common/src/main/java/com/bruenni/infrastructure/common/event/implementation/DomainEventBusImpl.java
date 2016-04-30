package com.bruenni.infrastructure.common.event.implementation;

import com.bruenni.infrastructure.common.event.IDomainEventBus;
import rx.Observable;
import rx.Observer;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bruenni on 30.04.16.
 */
public class DomainEventBusImpl<TEvent> implements IDomainEventBus<TEvent> {
    private List<Observer<TEvent>> observers = new LinkedList<Observer<TEvent>>();

    /**
     * Subcribes and adds to internal list.
     * @return
     */
    public Observable<TEvent> subscribe() {
        Subject<TEvent, TEvent> subject = ReplaySubject.create();
        this.observers.add(subject);
        return subject;
    }

    /**
     * Publishes to all observers.
     * @param tEvent
     */
    public void publish(TEvent tEvent) {
        for (Observer<TEvent> o :
                this.observers) {
            o.onNext(tEvent);
        }
    }
}
