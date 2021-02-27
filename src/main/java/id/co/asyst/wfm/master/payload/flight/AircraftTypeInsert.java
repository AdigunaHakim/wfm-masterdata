package id.co.asyst.wfm.master.payload.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;

public class AircraftTypeInsert {

    private String acTypeCode;

    private String acTypeDesc;

    private String acTypeGroupCode;

    private ActiveEnum active;

    public String getAcTypeCode() {
        return acTypeCode;
    }

    public void setAcTypeCode(String acTypeCode) {
        this.acTypeCode = acTypeCode;
    }

    public String getAcTypeDesc() {
        return acTypeDesc;
    }

    public void setAcTypeDesc(String acTypeDesc) {
        this.acTypeDesc = acTypeDesc;
    }

    public String getAcTypeGroupCode() {
        return acTypeGroupCode;
    }

    public void setAcTypeGroupCode(String acTypeGroupCode) {
        this.acTypeGroupCode = acTypeGroupCode;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
