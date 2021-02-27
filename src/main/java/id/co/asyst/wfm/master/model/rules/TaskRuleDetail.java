package id.co.asyst.wfm.master.model.rules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "TASK_RULE_DETAIL")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "lastUpdated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class TaskRuleDetail extends BaseModel{

    private static final long serialVersionUID = 7948797223936133683L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TASK_CODE")
    private TaskRule taskRules;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_CODE")
    private ArrivalProfile arrivalProfiles;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICE_CLASS")
    private ServiceClass serviceClass;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICE_GROUP")
    private ServiceGroup serviceGroups;

    @Column(name = "SERVICE_TIME", length = 5)
    private Integer serviceTime;

    @Column(name = "QUEUE_TIME", length = 5)
    private Integer queueTime;

    @Column(name = "ACT_PAX_F", length = 5)
    private Integer actPaxF;

    @Column(name = "ACT_PAX_C", length = 5)
    private Integer actPaxC;

    @Column(name = "ACT_PAX_Y", length = 5)
    private Integer actPaxY;

    @Column(name = "MIN_COUNT", length = 5)
    private Integer minCount;

    @Column(name = "MAX_COUNT", length = 5)
    private Integer maxCount;

    @Column(name = "MIN_TIME")
    private LocalTime minTime;

    @Column(name = "MAX_TIME")
    private LocalTime maxTime;

    @Column(name = "DEDUCTION", length = 5)
    private Integer deduction;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public TaskRule getTaskRules() {
        return taskRules;
    }

    public void setTaskRules(TaskRule taskRules) {
        this.taskRules = taskRules;
    }

    public ArrivalProfile getArrivalProfiles() {
        return arrivalProfiles;
    }

    public void setArrivalProfiles(ArrivalProfile arrivalProfiles) {
        this.arrivalProfiles = arrivalProfiles;
    }

    public ServiceClass getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }

    public ServiceGroup getServiceGroups() {
        return serviceGroups;
    }

    public void setServiceGroups(ServiceGroup serviceGroups) {
        this.serviceGroups = serviceGroups;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(Integer queueTime) {
        this.queueTime = queueTime;
    }

    public Integer getActPaxF() {
        return actPaxF;
    }

    public void setActPaxF(Integer actPaxF) {
        this.actPaxF = actPaxF;
    }

    public Integer getActPaxC() {
        return actPaxC;
    }

    public void setActPaxC(Integer actPaxC) {
        this.actPaxC = actPaxC;
    }

    public Integer getActPaxY() {
        return actPaxY;
    }

    public void setActPaxY(Integer actPaxY) {
        this.actPaxY = actPaxY;
    }

    public Integer getMinCount() {
        return minCount;
    }

    public void setMinCount(Integer minCount) {
        this.minCount = minCount;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public Integer getDeduction() {
        return deduction;
    }

    public void setDeduction(Integer deduction) {
        this.deduction = deduction;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
