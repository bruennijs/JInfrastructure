package infrastructure.common.event.test;

import infrastructure.common.event.implementation.TenantEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 19.06.16.
 */
public class EventTest {


    @Test
    public void when_tenantId_expected_correct_properties()
    {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID aggregateID = UUID.randomUUID();
        TenantEvent tenantEvent = new TenantEvent(id1, aggregateID, id2, new Date());
        Assert.assertEquals(id1, tenantEvent.getId());
        Assert.assertEquals(id2, tenantEvent.getTenantId());
        Assert.assertEquals(aggregateID, tenantEvent.getAggregateId());
    }

    public void when_event_expected_correct_properties()
    {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID aggregateID = UUID.randomUUID();
        MyEvent tenantEvent = new MyEvent(id1, aggregateID, new Date());
        Assert.assertEquals(id1, tenantEvent.getId());
        Assert.assertEquals(aggregateID, tenantEvent.getAggregateId());
    }
}
