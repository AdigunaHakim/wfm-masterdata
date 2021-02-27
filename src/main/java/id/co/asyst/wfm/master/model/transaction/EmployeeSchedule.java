package id.co.asyst.wfm.master.model.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Employee;
import id.co.asyst.wfm.master.model.employee.Function;
import id.co.asyst.wfm.master.model.employee.Qualification;
import id.co.asyst.wfm.master.model.schedule.ShiftType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "EMPLOYEE_SCHEDULE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class EmployeeSchedule extends BaseModel{

    @Id
    private String employeeScheduleId;

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "EMPLOYEE_GROUP")
    private String employeeGroup;

    @JoinColumn(name = "DATE", nullable = false)
    private LocalDate date;

    @Column(name = "SHIFT_TYPE_CODE")
    private String shiftTypeCode;

    @Column(name="SHIFT_PUBLISH_NAME")
    private String shiftPublishName;

    @Column(name="SHIFT_INDICATOR")
    private Integer shiftIndicator;

    @Column(name="SHIFT_STARTTIME")
    private LocalTime shiftStarttime;

    @Column(name = "SHIFT_ENDTIME")
    private LocalTime shiftEndtime;

    @Column(name = "FUNCTION_CODE")
    private String functionCode;

    @Column(name = "QUALIFICATION_CODE")
    private String qualificationCode;

    @Column(name = "ATTENDANCE_STATUS")
    private String attendanceStatus;

    @Column(name = "ATTENDANCE_REMINDER")
    private String attendanceReminder;

    private ActiveEnum active;

    private String org;

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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(String employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShiftTypeCode() {
        return shiftTypeCode;
    }

    public void setShiftTypeCode(String shiftTypeCode) {
        this.shiftTypeCode = shiftTypeCode;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public Integer getShiftIndicator() {
        return shiftIndicator;
    }

    public void setShiftIndicator(Integer shiftIndicator) {
        this.shiftIndicator = shiftIndicator;
    }

    public LocalTime getShiftStarttime() {
        return shiftStarttime;
    }

    public void setShiftStarttime(LocalTime shiftStarttime) {
        this.shiftStarttime = shiftStarttime;
    }

    public LocalTime getShiftEndtime() {
        return shiftEndtime;
    }

    public void setShiftEndtime(LocalTime shiftEndtime) {
        this.shiftEndtime = shiftEndtime;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getAttendanceReminder() {
        return attendanceReminder;
    }

    public void setAttendanceReminder(String attendanceReminder) {
        this.attendanceReminder = attendanceReminder;
    }

    public String getShiftPublishName() {
        return shiftPublishName;
    }

    public void setShiftPublishName(String shiftPublishName) {
        this.shiftPublishName = shiftPublishName;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
