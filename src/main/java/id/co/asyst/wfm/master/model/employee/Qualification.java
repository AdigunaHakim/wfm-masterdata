package id.co.asyst.wfm.master.model.employee;

import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "QUALIFICATION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Qualification extends BaseModel
{

    private static final long serialVersionUID = -2451942560309302798L;

    @Id
    @Column(name = "QUALIFICATION_CODE", nullable = false, unique = true, length = 50)
    private String qualificationCode;

    @Column(name = "QUALIFICATION_DESC", length = 50)
    private String qualificationDesc;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public String getQualificationDesc() {
        return qualificationDesc;
    }

    public void setQualificationDesc(String qualificationDesc) {
        this.qualificationDesc = qualificationDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

}
