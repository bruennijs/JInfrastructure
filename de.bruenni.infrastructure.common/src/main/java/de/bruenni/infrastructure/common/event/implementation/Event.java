package de.bruenni.infrastructure.common.event.implementation;

import de.bruenni.infrastructure.common.event.IEvent;

/**
 * Created by bruenni on 30.04.16.
 */
public class Event implements IEvent {
    private String id;

    /**
     * Constructor.
     * @param id
     */
    public Event(String id) {
        this.id = id;
    }

    /**
     * Gets the id.
     * @return
     */
    public String getId() {
        return id;
    }
}
