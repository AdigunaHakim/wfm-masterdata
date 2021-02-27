package id.co.asyst.wfm.master.model.transaction;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_ATTENDANCE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class EmployeeAttendance extends BaseModel{

    @Id
    private String  employeeAttendanceId;

    private String employeeScheduleId;

    private String employeeId;

    private Date actShiftStart;

    private Date actShiftEnd;

    private Integer actOvertime;

    private Integer totalWorkingHour;

    private String attendanceStatusCode;

    private ActiveEnum active;

    private String org;

    public String getEmployeeAttendanceId() {
        return employeeAttendanceId;
    }

    public void setEmployeeAttendanceId(String employeeAttendanceId) {
        this.employeeAttendanceId = employeeAttendanceId;
    }

    public String getEmployeeScheduleId() {
        return employeeScheduleId;
    }

    public void setEmployeeScheduleId(String employeeScheduleId) {
        this.employeeScheduleId = employeeScheduleId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getActShiftStart() {
        return actShiftStart;
    }

    public void setActShiftStart(Date actShiftStart) {
        this.actShiftStart = actShiftStart;
    }

    public Date getActShiftEnd() {
        return actShiftEnd;
    }

    public void setActShiftEnd(Date actShiftEnd) {
        this.actShiftEnd = actShiftEnd;
    }

    public Integer getActOvertime() {
        return actOvertime;
    }

    public void setActOvertime(Integer actOvertime) {
        this.actOvertime = actOvertime;
    }

    public Integer getTotalWorkingHour() {
        return totalWorkingHour;
    }

    public void setTotalWorkingHour(Integer totalWorkingHour) {
        this.totalWorkingHour = totalWorkingHour;
    }

    public String getAttendanceStatusCode() {
        return attendanceStatusCode;
    }

    public void setAttendanceStatusCode(String attendanceStatusCode) {
        this.attendanceStatusCode = attendanceStatusCode;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
