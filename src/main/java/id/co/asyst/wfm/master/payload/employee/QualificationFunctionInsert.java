package id.co.asyst.wfm.master.payload.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;

public class QualificationFunctionInsert {

    private String qualificationCode;
    private String qualificationDesc;
    private ActiveEnum active;
    private String[] function;

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public String getQualificationDesc() {
        return qualificationDesc;
    }

    public void setQualificationDesc(String qualificationDesc) {
        this.qualificationDesc = qualificationDesc;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String[] getFunction() {
        return function;
    }

    public void setFunction(String[] function) {
        this.function = function;
    }
}
