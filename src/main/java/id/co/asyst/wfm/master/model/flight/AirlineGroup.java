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
@Table(name = "AIRLINE_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class AirlineGroup extends BaseModel
{
    private static final long serialVersionUID = 2338686898955973883L;

    @Id
    @Column(name = "AIRLINE_GROUP_CODE", nullable = false, unique = true, length = 30)
    private String airlineGroupCode;

    @Column(name = "AIRLINE_GROUP_DESC", length = 50)
    private String airlineGroupDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getAirlineGroupCode() {
        return airlineGroupCode;
    }

    public void setAirlineGroupCode(String airlineGroupCode) {
        this.airlineGroupCode = airlineGroupCode;
    }

    public String getAirlineGroupDesc() {
        return airlineGroupDesc;
    }

    public void setAirlineGroupDesc(String airlineGroupDesc) {
        this.airlineGroupDesc = airlineGroupDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
