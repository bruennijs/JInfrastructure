package infrastructure.common;

import infrastructure.common.event.Event;
import infrastructure.persistence.Entity;
import infrastructure.persistence.IEntity;

import java.io.Serializable;

/**
 * Created by bruenni on 28.05.17.
 */
public interface Aggregate<TId extends Serializable,
	                       TEvent extends Event<? extends Serializable, ? extends Aggregate>> extends IEntity<TId> {

	/**
	 * Gets domain events.
	 * @return
	 */
	Iterable<TEvent> getEvents();
}
