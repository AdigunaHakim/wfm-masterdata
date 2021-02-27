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
@Table(name = "LOCATION_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class LocationType extends BaseModel
{

    private static final long serialVersionUID = -7952802511740269700L;

    @Id
    @Column(name = "LOCATION_TYPE_CODE", nullable = false, unique = true, length = 25)
    private String locationTypeCode;

    @Column(name ="LOCATION_TYPE_NAME", nullable = false, unique = true, length = 25)
    private String locationTypeName;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getLocationTypeCode() {
        return locationTypeCode;
    }

    public void setLocationTypeCode(String locationTypeCode) {
        this.locationTypeCode = locationTypeCode;
    }

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
