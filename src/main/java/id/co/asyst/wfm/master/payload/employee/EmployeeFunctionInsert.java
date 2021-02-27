package id.co.asyst.wfm.master.payload.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;

import java.time.LocalDate;

public class EmployeeFunctionInsert {

    private String employeeId;

    private String[] functionCode;

    private Integer[] enableValidFrom;

    private LocalDate[] validFrom;

    private Integer[] enableValidTo;

    private LocalDate[] validTo;

    private ActiveEnum active;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String[] getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String[] functionCode) {
        this.functionCode = functionCode;
    }

    public LocalDate[] getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate[] validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate[] getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate[] validTo) {
        this.validTo = validTo;
    }

    public Integer[] getEnableValidTo() {
        return enableValidTo;
    }

    public void setEnableValidTo(Integer[] enableValidTo) {
        this.enableValidTo = enableValidTo;
    }

    public Integer[] getEnableValidFrom() {
        return enableValidFrom;
    }

    public void setEnableValidFrom(Integer[] enableValidFrom) {
        this.enableValidFrom = enableValidFrom;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
