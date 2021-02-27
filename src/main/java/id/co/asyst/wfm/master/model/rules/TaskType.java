package id.co.asyst.wfm.master.model.rules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TASK_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "lastUpdated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class TaskType extends BaseModel {

    private static final long serialVersionUID = -2805794161524980611L;

    @Id
    @Column(name = "TASK_TYPE_CODE", length = 3)
    private String taskTypeCode;

    @Column(name = "TASK_TYPE_NAME", nullable = false, unique = true, length = 25)
    private String taskTypeName;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getTaskTypeCode() {
        return taskTypeCode;
    }

    public void setTaskTypeCode(String taskTypeCode) {
        this.taskTypeCode = taskTypeCode;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
