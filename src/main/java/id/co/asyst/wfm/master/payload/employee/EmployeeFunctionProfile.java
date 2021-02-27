package id.co.asyst.wfm.master.payload.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

public class EmployeeFunctionProfile {

    private BigInteger id;

    private String employeeId;

    private String functionCode;

    private Date validFrom;

    private Date validTo;

    public EmployeeFunctionProfile(BigInteger id, String employeeId, String functionCode, Date validFrom, Date validTo){

        this.id = id;
        this.employeeId = employeeId;
        this.functionCode = functionCode;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}
