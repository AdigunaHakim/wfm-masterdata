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
@Table(name = "AIRCRAFT_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class AircraftType extends BaseModel {
    private static final long serialVersionUID = 1279378395157003173L;

    @Id
    @Column(name = "AC_TYPE_CODE", nullable = false, length = 10)
    private String acTypeCode;

    @Column(name = "AC_TYPE_DESC", length = 50)
    private String acTypeDesc;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "AC_TYPE_GROUP_CODE", nullable = false)
    private AircraftTypeGroup aircraftTypeGroup;

    private ActiveEnum active;

    public String getAcTypeCode() {
        return acTypeCode;
    }

    public void setAcTypeCode(String acTypeCode) {
        this.acTypeCode = acTypeCode;
    }

    public String getAcTypeDesc() {
        return acTypeDesc;
    }

    public void setAcTypeDesc(String acTypeDesc) {
        this.acTypeDesc = acTypeDesc;
    }

    public AircraftTypeGroup getAircraftTypeGroup() {
        return aircraftTypeGroup;
    }

    public void setAircraftTypeGroup(AircraftTypeGroup aircraftTypeGroup) {
        this.aircraftTypeGroup = aircraftTypeGroup;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
