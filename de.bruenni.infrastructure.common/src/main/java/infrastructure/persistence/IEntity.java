package infrastructure.persistence;

import java.io.Serializable;

/**
 * Created by bruenni on 19.06.16.
 */
public interface IEntity<TId extends Serializable> {

    /**
     * Gets the entity id.
     * @return
     */
    TId getId();
}
