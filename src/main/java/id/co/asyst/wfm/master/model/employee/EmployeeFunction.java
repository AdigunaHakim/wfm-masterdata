package id.co.asyst.wfm.master.model.employee;

import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_FUNCTION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class EmployeeFunction extends BaseModel {

    private static final long serialVersionUID = 3365845971714824445L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FUNCTION_CODE", nullable = false)
    private Function function;

    @Column(name = "ENABLE_VALID_FROM")
    private Integer enableValidFrom;

    @Column(name ="VALID_FROM", nullable = true)
    private LocalDate validFrom;

    @Column(name = "ENABLE_VALID_TO")
    private Integer enableValidTo;

    @Column(name ="VALID_TO", nullable = true)
    private LocalDate validTo;

    private ActiveEnum active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Integer getEnableValidTo() {
        return enableValidTo;
    }

    public void setEnableValidTo(Integer enableValidTo) {
        this.enableValidTo = enableValidTo;
    }

    public Integer getEnableValidFrom() {
        return enableValidFrom;
    }

    public void setEnableValidFrom(Integer enableValidFrom) {
        this.enableValidFrom = enableValidFrom;
    }
}
