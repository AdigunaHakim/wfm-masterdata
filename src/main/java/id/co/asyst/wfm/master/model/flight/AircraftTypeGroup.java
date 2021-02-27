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
@Table(name = "AIRCRAFT_TYPE_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class AircraftTypeGroup extends BaseModel
{
    private static final long serialVersionUID = 7437914508612085873L;

    @Id
    @Column(name = "AC_TYPE_GROUP_CODE", nullable = false, unique = true, length = 10)
    private String acTypeGroupCode;

    @Column(name = "AC_TYPE_GROUP_DESC", length = 50)
    private String acTypeGroupDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getAcTypeGroupCode() {
        return acTypeGroupCode;
    }

    public void setAcTypeGroupCode(String acTypeGroupCode) {
        this.acTypeGroupCode = acTypeGroupCode;
    }

    public String getAcTypeGroupDesc() {
        return acTypeGroupDesc;
    }

    public void setAcTypeGroupDesc(String acTypeGroupDesc) {
        this.acTypeGroupDesc = acTypeGroupDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
