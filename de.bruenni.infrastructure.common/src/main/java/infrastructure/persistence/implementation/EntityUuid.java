package infrastructure.persistence.implementation;

import infrastructure.persistence.EntityId;

import java.util.UUID;

/**
 * Created by bruenni on 19.06.16.
 */
public class EntityUuid extends EntityId {

    private UUID id;

    public EntityUuid() {
        this.id = UUID.randomUUID();
    }

    public EntityUuid(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    protected String getValue() {
        return null;
    }
}
