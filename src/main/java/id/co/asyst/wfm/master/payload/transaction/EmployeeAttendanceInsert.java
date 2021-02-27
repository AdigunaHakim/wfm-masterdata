package id.co.asyst.wfm.master.payload.transaction;

import id.co.asyst.wfm.master.model.AbsenceEnum;
import id.co.asyst.wfm.master.model.ActiveEnum;

import java.util.Date;

public class EmployeeAttendanceInsert {

    private String employeeId;

    private String org;

    private Date timestamp;

    private AbsenceEnum status;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public AbsenceEnum getStatus() {
        return status;
    }

    public void setStatus(AbsenceEnum status) {
        this.status = status;
    }
}
