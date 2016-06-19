package infrastructure.persistence;

/**
 * Created by bruenni on 08.06.16.
 */
public abstract class Entity<T> implements IEntity<T> {
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
}
