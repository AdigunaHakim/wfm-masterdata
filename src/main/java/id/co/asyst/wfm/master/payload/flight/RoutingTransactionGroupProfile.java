package id.co.asyst.wfm.master.payload.flight;

public class RoutingTransactionGroupProfile {

    private String routingGroupCode;

    private String routingCode;


    public RoutingTransactionGroupProfile(String routingGroupCode, String routingCode){

        this.routingGroupCode = routingGroupCode;
        this.routingCode = routingCode;
    }

    public String getRoutingGroupCode() {
        return routingGroupCode;
    }

    public void setRoutingGroupCode(String routingGroupCode) {
        this.routingGroupCode = routingGroupCode;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }
}
