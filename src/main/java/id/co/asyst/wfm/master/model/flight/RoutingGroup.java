package id.co.asyst.wfm.master.model.flight;

import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ROUTING_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class RoutingGroup extends BaseModel
{
    private static final long serialVersionUID = -4671634626225025416L;

    @Id
    @Column(name = "ROUTING_GROUP_CODE", length = 5)
    private String routingGroupCode;

    @Column(name = "ROUTING_GROUP_DESC", length = 50)
    private String routingGroupDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoutingGroupCode() {
        return routingGroupCode;
    }

    public void setRoutingGroupCode(String routingGroupCode) {
        this.routingGroupCode = routingGroupCode;
    }

    public String getRoutingGroupDesc() {
        return routingGroupDesc;
    }

    public void setRoutingGroupDesc(String routingGroupDesc) {
        this.routingGroupDesc = routingGroupDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
