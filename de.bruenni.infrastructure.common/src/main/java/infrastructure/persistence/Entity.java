package infrastructure.persistence;

import java.io.Serializable;

/**
 * Created by bruenni on 08.06.16.
 */
public abstract class Entity<T extends Serializable> implements IEntity<T> {
    private T id;

    /**
     * Constcrutor.
     * @param id
     */
    public Entity(T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
