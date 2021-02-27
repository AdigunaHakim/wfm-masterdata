package id.co.asyst.wfm.master.model.employee;

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
@Table(name = "EMPLOYEE_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class EmployeeGroup extends BaseModel
{

    private static final long serialVersionUID = 3175920395011308522L;

    @Id
    @Column(name = "EMPLOYEE_GROUP_CODE", nullable = false, unique = true, length = 10)
    private String employeeGroupCode;

    @Column(name = "EMPLOYEE_GROUP_DESC", length = 50)
    private String employeeGroupDesc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRANCH_CODE")
    private Branch branchs;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getEmployeeGroupCode() {
        return employeeGroupCode;
    }

    public void setEmployeeGroupCode(String employeeGroupCode) {
        this.employeeGroupCode = employeeGroupCode;
    }

    public String getEmployeeGroupDesc() {
        return employeeGroupDesc;
    }

    public void setEmployeeGroupDesc(String employeeGroupDesc) {
        this.employeeGroupDesc = employeeGroupDesc;
    }

    public Branch getBranchs() {
        return branchs;
    }

    public void setBranchs(Branch branchs) {
        this.branchs = branchs;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
