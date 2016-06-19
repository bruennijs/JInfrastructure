package infrastructure.persistence;

import java.io.Serializable;

/**
 * Created by bruenni on 19.06.16.
 */
public abstract class EntityId implements Serializable {

    /***
     * Gets the value as String representation
     * @return
     */
    protected abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }
}
