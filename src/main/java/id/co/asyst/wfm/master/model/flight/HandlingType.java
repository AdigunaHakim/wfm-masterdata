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
@Table(name = "HANDLING_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class HandlingType extends BaseModel
{
    private static final long serialVersionUID = -8395895864518933382L;

    @Id
    @Column(name = "HANDLING_TYPE_CODE", nullable = false, unique = true, length = 2)
    private String handlingTypeCode;

    @Column(name = "HANDLING_TYPE_DESC", length = 50)
    private String handlingTypeDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHandlingTypeCode() {
        return handlingTypeCode;
    }

    public void setHandlingTypeCode(String handlingTypeCode) {
        this.handlingTypeCode = handlingTypeCode;
    }

    public String getHandlingTypeDesc() {
        return handlingTypeDesc;
    }

    public void setHandlingTypeDesc(String handlingTypeDesc) {
        this.handlingTypeDesc = handlingTypeDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
