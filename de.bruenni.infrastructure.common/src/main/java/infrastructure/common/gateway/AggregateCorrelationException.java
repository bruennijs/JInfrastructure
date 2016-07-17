package infrastructure.common.gateway;

/**
 * Created by bruenni on 25.06.16.
 */
public class AggregateCorrelationException extends Throwable {
    private String correlationId;
    private String aggregateId;

    public AggregateCorrelationException(String correlationId, String aggregateId, String message) {
        super(message);
        this.correlationId = correlationId;
        this.aggregateId = aggregateId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getAggregateId() {
        return aggregateId;
    }
}
