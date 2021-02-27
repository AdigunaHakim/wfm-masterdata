package id.co.asyst.wfm.master.payload.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;

public class FunctionQualificationInsert {

    private String functionCode;
    private String functionDesc;
    private ActiveEnum active;
    private String[] qualification;

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String[] getQualification() {
        return qualification;
    }

    public void setQualification(String[] qualification) {
        this.qualification = qualification;
    }
}
