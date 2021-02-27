package id.co.asyst.wfm.master.payload.flight;

public class AirlineTransactionGroupProfile {

    private String airlineGroupCode;

    private String airlineCode;


    public AirlineTransactionGroupProfile(String airlineGroupCode, String airlineCode){

        this.airlineGroupCode = airlineGroupCode;
        this.airlineCode = airlineCode;
    }

    public String getAirlineGroupCode() {
        return airlineGroupCode;
    }

    public void setAirlineGroupCode(String airlineGroupCode) {
        this.airlineGroupCode = airlineGroupCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
}
