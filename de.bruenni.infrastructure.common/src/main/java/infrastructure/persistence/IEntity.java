package infrastructure.persistence;

/**
 * Created by bruenni on 19.06.16.
 */
public interface IEntity<T> {

    /**
     * Gets the entity id.
     * @return
     */
    T getId();
}
