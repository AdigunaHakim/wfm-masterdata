package id.co.asyst.wfm.master.model.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "ROUTING_TRANSACTION_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class RoutingTransactionGroup extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROUTING_CODE", nullable = false)
    private Routing routing;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROUTING_GROUP_CODE", nullable = false)
    private RoutingGroup routingGroup;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Routing getRouting() {
        return routing;
    }

    public void setRouting(Routing routing) {
        this.routing = routing;
    }

    public RoutingGroup getRoutingGroup() {
        return routingGroup;
    }

    public void setRoutingGroup(RoutingGroup routingGroup) {
        this.routingGroup = routingGroup;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
