package id.co.asyst.wfm.master.model.rules;

import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_CLASS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class ServiceClass extends BaseModel
{
    private static final long serialVersionUID = -7625374154072457961L;

    @Id
    @Column(name = "SERVICE_CLASS_CODE", nullable = false, unique = true, length = 25)
    private String serviceClassCode;

    @Column(name = "SERVICE_CLASS_DESC", length = 25)
    private String serviceClassDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getServiceClassCode() {
        return serviceClassCode;
    }

    public void setServiceClassCode(String serviceClassCode) {
        this.serviceClassCode = serviceClassCode;
    }

    public String getServiceClassDesc() {
        return serviceClassDesc;
    }

    public void setServiceClassDesc(String serviceClassDesc) {
        this.serviceClassDesc = serviceClassDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
