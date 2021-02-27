package id.co.asyst.wfm.master.payload.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;

public class AirlineTransactionGroupInsert {

    private String airlineGroupCode;

    private String airlineGroupDesc;

    private String[] airlineCode;

    private ActiveEnum active;

    public String[] getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String[] airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineGroupCode() {
        return airlineGroupCode;
    }

    public void setAirlineGroupCode(String airlineGroupCode) {
        this.airlineGroupCode = airlineGroupCode;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String getAirlineGroupDesc() {
        return airlineGroupDesc;
    }

    public void setAirlineGroupDesc(String airlineGroupDesc) {
        this.airlineGroupDesc = airlineGroupDesc;
    }
}
