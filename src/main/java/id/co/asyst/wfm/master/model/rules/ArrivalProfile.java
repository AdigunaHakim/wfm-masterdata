package id.co.asyst.wfm.master.model.rules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARRIVAL_PROFILE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "lastUpdated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class ArrivalProfile extends BaseModel {

    private static final long serialVersionUID = -4553905360144282796L;

    @Id
    @Column(name = "PROFILE_CODE", length = 20, unique = true, nullable = false)
    private String profileCode;

    @Column(name = "PROFIE_NAME", nullable = false, length = 25)
    private String profileName;

    @Column(name = "SEQUENCE")
    private Integer sequence;

    @Column(name = "START_TIME")
    private Integer startTime;

    @Column(name = "END_TIME")
    private Integer endTime;

    @Column(name = "PERCENTAGE")
    private Integer percentage;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
