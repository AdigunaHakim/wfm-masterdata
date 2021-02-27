package id.co.asyst.wfm.master.model.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.core.model.Model;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.HandlingType;
import id.co.asyst.wfm.master.model.flight.Routing;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "FLIGHT_DATA")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class FlightData extends BaseModel {

    @Id
    private String flightDataId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "airline_code", nullable = false)
    private Airline airline;

    private LocalDate flightDate;

    private String tripNumber;

    private String suffix;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime st;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime et;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime at;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime bt;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime blockTime;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone="CET")
    private LocalTime btPrev;

    private Integer paxLocal;

    private Integer paxTransit;

    private Integer paxXfer;

    private Integer paxF;

    private Integer paxC;

    private Integer paxY;

    private Integer paxTotal;

    private Integer bagLocal;

    private Integer bagTransit;

    private Integer bagXfer;

    private Integer bagTotal;

    private String phase;

    private String station;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "routing_code", nullable = false)
    private Routing routing;

    private String leg;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ac_type_code", nullable = false)
    private AircraftType aircraftType;

    private String acReg;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "handling_type_code", nullable = false)
    private HandlingType handlingType;

    private Integer linkFlightId;

    private String delayCode;

    private Integer delayDuration;

    private String handlingType2;

    private Integer returnCounter;

    private String term;

    private String hostbelt;

    private String hostcheckIn;

    private String hostGat;

    private String hostPos;

    private ActiveEnum active;

    private String org;

    public String getFlightDataId() {
        return flightDataId;
    }

    public void setFlightDataId(String flightDataId) {
        this.flightDataId = flightDataId;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public LocalTime getSt() {
        return st;
    }

    public void setSt(LocalTime st) {
        this.st = st;
    }

    public LocalTime getEt() {
        return et;
    }

    public void setEt(LocalTime et) {
        this.et = et;
    }

    public LocalTime getAt() {
        return at;
    }

    public void setAt(LocalTime at) {
        this.at = at;
    }

    public LocalTime getBt() {
        return bt;
    }

    public void setBt(LocalTime bt) {
        this.bt = bt;
    }

    public LocalTime getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(LocalTime blockTime) {
        this.blockTime = blockTime;
    }

    public LocalTime getBtPrev() {
        return btPrev;
    }

    public void setBtPrev(LocalTime btPrev) {
        this.btPrev = btPrev;
    }

    public Integer getPaxLocal() {
        return paxLocal;
    }

    public void setPaxLocal(Integer paxLocal) {
        this.paxLocal = paxLocal;
    }

    public Integer getPaxTransit() {
        return paxTransit;
    }

    public void setPaxTransit(Integer paxTransit) {
        this.paxTransit = paxTransit;
    }

    public Integer getPaxXfer() {
        return paxXfer;
    }

    public void setPaxXfer(Integer paxXfer) {
        this.paxXfer = paxXfer;
    }

    public Integer getPaxF() {
        return paxF;
    }

    public void setPaxF(Integer paxF) {
        this.paxF = paxF;
    }

    public Integer getPaxC() {
        return paxC;
    }

    public void setPaxC(Integer paxC) {
        this.paxC = paxC;
    }

    public Integer getPaxY() {
        return paxY;
    }

    public void setPaxY(Integer paxY) {
        this.paxY = paxY;
    }

    public Integer getPaxTotal() {
        return paxTotal;
    }

    public void setPaxTotal(Integer paxTotal) {
        this.paxTotal = paxTotal;
    }

    public Integer getBagLocal() {
        return bagLocal;
    }

    public void setBagLocal(Integer bagLocal) {
        this.bagLocal = bagLocal;
    }

    public Integer getBagTransit() {
        return bagTransit;
    }

    public void setBagTransit(Integer bagTransit) {
        this.bagTransit = bagTransit;
    }

    public Integer getBagXfer() {
        return bagXfer;
    }

    public void setBagXfer(Integer bagXfer) {
        this.bagXfer = bagXfer;
    }

    public Integer getBagTotal() {
        return bagTotal;
    }

    public void setBagTotal(Integer bagTotal) {
        this.bagTotal = bagTotal;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Routing getRouting() {
        return routing;
    }

    public void setRouting(Routing routing) {
        this.routing = routing;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAcReg() {
        return acReg;
    }

    public void setAcReg(String acReg) {
        this.acReg = acReg;
    }

    public HandlingType getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(HandlingType handlingType) {
        this.handlingType = handlingType;
    }

    public Integer getLinkFlightId() {
        return linkFlightId;
    }

    public void setLinkFlightId(Integer linkFlightId) {
        this.linkFlightId = linkFlightId;
    }

    public String getDelayCode() {
        return delayCode;
    }

    public void setDelayCode(String delayCode) {
        this.delayCode = delayCode;
    }

    public Integer getDelayDuration() {
        return delayDuration;
    }

    public void setDelayDuration(Integer delayDuration) {
        this.delayDuration = delayDuration;
    }

    public String getHandlingType2() {
        return handlingType2;
    }

    public void setHandlingType2(String handlingType2) {
        this.handlingType2 = handlingType2;
    }

    public Integer getReturnCounter() {
        return returnCounter;
    }

    public void setReturnCounter(Integer returnCounter) {
        this.returnCounter = returnCounter;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getHostbelt() {
        return hostbelt;
    }

    public void setHostbelt(String hostbelt) {
        this.hostbelt = hostbelt;
    }

    public String getHostcheckIn() {
        return hostcheckIn;
    }

    public void setHostcheckIn(String hostcheckIn) {
        this.hostcheckIn = hostcheckIn;
    }

    public String getHostGat() {
        return hostGat;
    }

    public void setHostGat(String hostGat) {
        this.hostGat = hostGat;
    }

    public String getHostPos() {
        return hostPos;
    }

    public void setHostPos(String hostPos) {
        this.hostPos = hostPos;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
