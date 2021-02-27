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
@Table(name = "AIRLINE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Airline extends BaseModel
{
    private static final long serialVersionUID = -4201811223986929191L;

    @Id
    @Column(name = "AIRLINE_CODE", nullable = false, unique = true, length = 2)
    private String airlineCode;

    @Column(name = "ICAO_CODE", nullable = false, length = 3)
    private String icaoCode;

    @Column(name = "AIRLINE_DESC", length = 100, nullable = false)
    private String airlineDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getAirlineDesc() {
        return airlineDesc;
    }

    public void setAirlineDesc(String airlineDesc) {
        this.airlineDesc = airlineDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
