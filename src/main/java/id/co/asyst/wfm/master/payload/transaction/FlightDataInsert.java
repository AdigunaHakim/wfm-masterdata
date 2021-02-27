package id.co.asyst.wfm.master.payload.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.asyst.wfm.master.model.ActiveEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDataInsert {

    private String airlineCode;

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

    private Integer PaxF;

    private Integer PaxC;

    private Integer paxY;

    private Integer paxTotal;

    private Integer bagLocal;

    private Integer bagTransit;

    private Integer bagXfer;

    private Integer bagTotal;

    private String phase;

    private String station;

    private String routingCode;

    private String leg;

    private String acTypeCode;

    private String acReg;

    private Integer linkFlightId;

    private String delayCode;

    private String delayCode2;

    private String delayCode3;

    private String delayCode4;

    private Integer delayDuration;

    private Integer delayDuration2;

    private Integer delayDuration3;

    private Integer delayDuration4;

    private String handlingType;

    private String handlingType2;

    private Integer returnCounter;

    private String term;

    private String hostbelt;

    private String hostcheckIn;

    private String hostGat;

    private String hostPos;

    private String org;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
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
        return PaxF;
    }

    public void setPaxF(Integer paxF) {
        PaxF = paxF;
    }

    public Integer getPaxC() {
        return PaxC;
    }

    public void setPaxC(Integer paxC) {
        PaxC = paxC;
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

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public String getAcTypeCode() {
        return acTypeCode;
    }

    public void setAcTypeCode(String acTypeCode) {
        this.acTypeCode = acTypeCode;
    }

    public String getAcReg() {
        return acReg;
    }

    public void setAcReg(String acReg) {
        this.acReg = acReg;
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

    public String getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(String handlingType) {
        this.handlingType = handlingType;
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDelayCode2() {
        return delayCode2;
    }

    public void setDelayCode2(String delayCode2) {
        this.delayCode2 = delayCode2;
    }

    public String getDelayCode3() {
        return delayCode3;
    }

    public void setDelayCode3(String delayCode3) {
        this.delayCode3 = delayCode3;
    }

    public String getDelayCode4() {
        return delayCode4;
    }

    public void setDelayCode4(String delayCode4) {
        this.delayCode4 = delayCode4;
    }

    public Integer getDelayDuration2() {
        return delayDuration2;
    }

    public void setDelayDuration2(Integer delayDuration2) {
        this.delayDuration2 = delayDuration2;
    }

    public Integer getDelayDuration3() {
        return delayDuration3;
    }

    public void setDelayDuration3(Integer delayDuration3) {
        this.delayDuration3 = delayDuration3;
    }

    public Integer getDelayDuration4() {
        return delayDuration4;
    }

    public void setDelayDuration4(Integer delayDuration4) {
        this.delayDuration4 = delayDuration4;
    }
}
