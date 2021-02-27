package id.co.asyst.wfm.master.payload.transaction;

import id.co.asyst.wfm.master.model.transaction.FlightData;

import java.util.List;

public class FlightDataMonitoring {

    private String station;
    private String hostPos;
    private List<FlightData> flightData;

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getHostPos() {
        return hostPos;
    }

    public void setHostPos(String hostPos) {
        this.hostPos = hostPos;
    }

    public List<FlightData> getFlightData() {
        return flightData;
    }

    public void setFlightData(List<FlightData> flightData) {
        this.flightData = flightData;
    }
}
