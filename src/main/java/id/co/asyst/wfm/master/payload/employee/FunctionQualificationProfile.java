package id.co.asyst.wfm.master.payload.employee;

public class FunctionQualificationProfile {

    private String functionCode;
    private String qualificationCode;

    public FunctionQualificationProfile(String functionCode, String qualificationCode) {
        this.functionCode = functionCode;
        this.qualificationCode = qualificationCode;
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
}
