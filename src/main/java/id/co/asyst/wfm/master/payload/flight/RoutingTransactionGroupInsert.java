package id.co.asyst.wfm.master.payload.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;

public class RoutingTransactionGroupInsert {

    private String routingGroupCode;

    private String routingGroupDesc;

    private String[] routingCode;

    private ActiveEnum active;

    public String getRoutingGroupCode() {
        return routingGroupCode;
    }

    public void setRoutingGroupCode(String routingGroupCode) {
        this.routingGroupCode = routingGroupCode;
    }

    public String getRoutingGroupDesc() {
        return routingGroupDesc;
    }

    public void setRoutingGroupDesc(String routingGroupDesc) {
        this.routingGroupDesc = routingGroupDesc;
    }

    public String[] getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String[] routingCode) {
        this.routingCode = routingCode;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
