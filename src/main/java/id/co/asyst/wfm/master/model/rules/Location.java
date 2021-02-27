package id.co.asyst.wfm.master.model.rules;

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
@Table(name = "LOCATION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Location extends BaseModel
{
    private static final long serialVersionUID = -1506602601022977325L;

    @Id
    @Column(name = "LOCATION_CODE", nullable = false, length = 25)
    private String locationCode;

    @Column(name ="LOCATION_DESC", length = 100)
    private String locationDesc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_TYPE_CODE", nullable = false)
    private LocationType locationType;

    @Column(name = "TERMINAL", length = 5)
    private String terminal;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
