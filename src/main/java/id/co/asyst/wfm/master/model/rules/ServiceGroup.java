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
@Table(name = "SERVICE_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class ServiceGroup extends BaseModel
{
    private static final long serialVersionUID = -7243812801384893309L;

    @Id
    @Column(name = "SERVICE_GROUP_CODE", nullable = false, unique = true, length = 25)
    private String serviceGroupCode;

    @Column(name = "SERVICE_GROUP_DESC", length = 25)
    private String serviceGroupDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getServiceGroupCode() {
        return serviceGroupCode;
    }

    public void setServiceGroupCode(String serviceGroupCode) {
        this.serviceGroupCode = serviceGroupCode;
    }

    public String getServiceGroupDesc() {
        return serviceGroupDesc;
    }

    public void setServiceGroupDesc(String serviceGroupDesc) {
        this.serviceGroupDesc = serviceGroupDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
