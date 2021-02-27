package id.co.asyst.wfm.master.model.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "SHIFT_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class ShiftType extends BaseModel
{
    private static final long serialVersionUID = -8312540535582099606L;

    @Id
    @Column(name = "SHIFT_TYPE_CODE", nullable = false, unique = true, length = 25)
    private String shiftTypeCode;

    @Column(name = "PUBLISH_NAME", nullable = false, unique = true, length = 3)
    private String publishName;

    @Column(name = "NORMAL_STARTTIME", nullable = false)
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime normalStarttime;

    @Column(name = "NORMAL_ENDTIME", nullable = false)
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime normalEndtime;

    @Column(name = "OVERTIME_STARTTIME")
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime overtimeStarttime;

    @Column(name = "OVERTIME_ENDTIME")
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime overtimeEndtime;

    @Column(name = "SHIFT_INDICATOR")
    private Integer shiftIndicator;

    private ActiveEnum active;

    public String getShiftTypeCode() {
        return shiftTypeCode;
    }

    public void setShiftTypeCode(String shiftTypeCode) {
        this.shiftTypeCode = shiftTypeCode;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public LocalTime getNormalStarttime() {
        return normalStarttime;
    }

    public void setNormalStarttime(LocalTime normalStarttime) {
        this.normalStarttime = normalStarttime;
    }

    public LocalTime getNormalEndtime() {
        return normalEndtime;
    }

    public void setNormalEndtime(LocalTime normalEndtime) {
        this.normalEndtime = normalEndtime;
    }

    public LocalTime getOvertimeStarttime() {
        return overtimeStarttime;
    }

    public void setOvertimeStarttime(LocalTime overtimeStarttime) {
        this.overtimeStarttime = overtimeStarttime;
    }

    public LocalTime getOvertimeEndtime() {
        return overtimeEndtime;
    }

    public void setOvertimeEndtime(LocalTime overtimeEndtime) {
        this.overtimeEndtime = overtimeEndtime;
    }

    public Integer getShiftIndicator() {
        return shiftIndicator;
    }

    public void setShiftIndicator(Integer shiftIndicator) {
        this.shiftIndicator = shiftIndicator;
    }
}
