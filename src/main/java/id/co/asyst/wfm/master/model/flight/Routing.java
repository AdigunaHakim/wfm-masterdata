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
@Table(name = "ROUTING")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Routing extends BaseModel
{
    private static final long serialVersionUID = 7627319081087666539L;

    @Id
    @Column(name = "ROUTING_CODE", nullable = false, unique = true, length = 3)
    private String routingCode;

    @Column(name = "ROUTING_DESC", length = 50)
    private String routingDesc;

    @Column(name = "IATA_CITY_CODE", length = 3)
    private String iataCityCode;

    @Column(name = "ICAO_AIRPORT_CODE", length = 50)
    private String icaoAirportCode;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    public String getRoutingDesc() {
        return routingDesc;
    }

    public void setRoutingDesc(String routingDesc) {
        this.routingDesc = routingDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String getIataCityCode() {
        return iataCityCode;
    }

    public void setIataCityCode(String iataCityCode) {
        this.iataCityCode = iataCityCode;
    }

    public String getIcaoAirportCode() {
        return icaoAirportCode;
    }

    public void setIcaoAirportCode(String icaoAirportCode) {
        this.icaoAirportCode = icaoAirportCode;
    }
}
