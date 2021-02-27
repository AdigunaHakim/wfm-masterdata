package id.co.asyst.wfm.master.controller.transaction;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.HandlingType;
import id.co.asyst.wfm.master.model.flight.Routing;
import id.co.asyst.wfm.master.model.transaction.FlightData;
import id.co.asyst.wfm.master.payload.transaction.FlightDataInsert;
import id.co.asyst.wfm.master.payload.transaction.FlightDataMonitoring;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.AircraftTypeService;
import id.co.asyst.wfm.master.service.flight.AirlineService;
import id.co.asyst.wfm.master.service.flight.RoutingService;
import id.co.asyst.wfm.master.service.flight.HandlingTypeService;
import id.co.asyst.wfm.master.service.transaction.FlightDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction/flight-data")
public class FlightDataController {

    @Autowired
    AirlineService airlineService;

    @Autowired
    RoutingService routingService;

    @Autowired
    AircraftTypeService aircraftTypeService;

    @Autowired
    HandlingTypeService handlingTypeService;

    @Autowired
    FlightDataService flightDataService;

    @GetMapping("/list/station")
    public List<String> getStationAll() {
        return (List<String>) flightDataService.getListStation();
    }

    @GetMapping("/list")
    public List<FlightData> getAll() {
        return (List<FlightData>) flightDataService.findAll();
    }

    @GetMapping(value = "/list", params = {"station", "flightId", "flightDate", "phase", "acReg", "hostpos"})
    public Page<FlightData> getAll(@RequestParam("station") String station, @RequestParam("flightId") String flightId,
                                   @RequestParam("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate, @RequestParam("phase") String phase,
                                   @RequestParam("acReg") String acReg, @RequestParam("hostpos") String hostpos, Pageable pageable) {

        Page<FlightData> flightData = null;
        if(flightDate == null){
            flightData = flightDataService.search(station, flightId, phase, acReg, hostpos, ActiveEnum.Y, pageable);
        }
        else{
            flightData = flightDataService.searchWithDate(station, flightId, flightDate, phase, acReg, hostpos, ActiveEnum.Y, pageable);
        }
        return flightData;
    }

    @PostMapping("/create")
    public ResponseProfile create(@Valid @RequestBody FlightDataInsert flightDataDetail) {

        FlightData flightData = new FlightData();
        ResponseProfile responseProfile = new ResponseProfile();
        Integer airlineCheck = airlineService.countById(flightDataDetail.getAirlineCode());
        Integer routingCheck = routingService.countById(flightDataDetail.getRoutingCode());
        Integer aircraftCheck = aircraftTypeService.countById(flightDataDetail.getAcTypeCode());
        Integer handlingCheck = handlingTypeService.countById(flightDataDetail.getHandlingType());
        Integer finalCheck = airlineCheck + routingCheck + aircraftCheck + handlingCheck;

        if (finalCheck >= 4){
            Airline airline = (Airline) airlineService.findById(flightDataDetail.getAirlineCode());
            Routing routing = (Routing) routingService.findById(flightDataDetail.getRoutingCode());
            AircraftType aircraftType = (AircraftType) aircraftTypeService.findById(flightDataDetail.getAcTypeCode());
            HandlingType handlingType = (HandlingType) handlingTypeService.findById(flightDataDetail.getHandlingType());
            String flightDate = flightDataDetail.getFlightDate().toString();
            String id = flightDataDetail.getOrg().concat(flightDataDetail.getAirlineCode()).concat(flightDataDetail.getTripNumber()).
                    concat(flightDataDetail.getRoutingCode()).concat(flightDataDetail.getSuffix()).
                    concat(flightDate.replaceAll("-","")).toUpperCase();

            flightData.setFlightDataId(id);
            flightData.setAirline(airline);
            flightData.setFlightDate(flightDataDetail.getFlightDate());
            flightData.setTripNumber(flightDataDetail.getTripNumber());
            flightData.setSuffix(flightDataDetail.getSuffix());
            flightData.setSt(flightDataDetail.getSt());
            flightData.setEt(flightDataDetail.getEt());
            flightData.setAt(flightDataDetail.getAt());
            flightData.setBt(flightDataDetail.getBt());
            flightData.setBlockTime(flightDataDetail.getBlockTime());
            flightData.setBtPrev(flightDataDetail.getBtPrev());
            flightData.setPaxLocal(flightDataDetail.getPaxLocal());
            flightData.setPaxTransit(flightDataDetail.getPaxTransit());
            flightData.setPaxXfer(flightDataDetail.getPaxXfer());
            flightData.setPaxF(flightDataDetail.getPaxF());
            flightData.setPaxC(flightDataDetail.getPaxC());
            flightData.setPaxY(flightDataDetail.getPaxY());
            flightData.setPaxTotal(flightDataDetail.getPaxTotal());
            flightData.setBagLocal(flightDataDetail.getBagLocal());
            flightData.setBagTransit(flightDataDetail.getBagTransit());
            flightData.setBagXfer(flightDataDetail.getBagXfer());
            flightData.setBagTotal(flightDataDetail.getBagTotal());
            flightData.setPhase(flightDataDetail.getPhase());
            flightData.setStation(flightDataDetail.getStation());
            flightData.setRouting(routing);
            flightData.setLeg(flightDataDetail.getLeg());
            flightData.setAircraftType(aircraftType);
            flightData.setAcReg(flightDataDetail.getAcReg());
            flightData.setHandlingType(handlingType);
            flightData.setLinkFlightId(flightDataDetail.getLinkFlightId());
            flightData.setDelayCode(flightDataDetail.getDelayCode());
            flightData.setHandlingType2(flightDataDetail.getHandlingType2());
            flightData.setReturnCounter(flightDataDetail.getReturnCounter());
            flightData.setTerm(flightDataDetail.getTerm());
            flightData.setHostbelt(flightDataDetail.getHostbelt());
            flightData.setHostcheckIn(flightDataDetail.getHostcheckIn());
            flightData.setHostGat(flightDataDetail.getHostGat());
            flightData.setHostPos(flightDataDetail.getHostPos());
            flightData.setOrg(flightDataDetail.getOrg());
            flightData.setActive(ActiveEnum.Y);

            flightDataService.saveOrUpdate(flightData);
            responseProfile = new ResponseProfile("0000", "Success", "flightdata", flightData);
        }
        else if(airlineCheck == 0){
            responseProfile = new ResponseProfile("0001", "Error (Airline Not Found :" +flightDataDetail.getAirlineCode()+")", "flightdata", null);
        }
        else if(routingCheck == 0){
            responseProfile = new ResponseProfile("0001", "Error (Route Not Found : "+flightDataDetail.getRoutingCode()+")", "flightdata", null);

        }
        else if(aircraftCheck == 0){
            responseProfile = new ResponseProfile("0001", "Error (Aircraft Type Not Found : "+flightDataDetail.getAcTypeCode()+")", "flightdata", null);
        }
        else{
            responseProfile = new ResponseProfile("0001", "Error ( Handling Type Not Found : "+flightDataDetail.getHandlingType()+")", "flightdata", null);
        }
        return responseProfile;
    }

    @GetMapping(value = "/monitoring", params = {"flightDate","station"})
    public List<FlightDataMonitoring> getTaskMonitoring(
            @RequestParam("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date,
            @RequestParam("station") String station) {

        LocalDate startDate = date.minusDays(1);
        LocalDate endDate = date.plusDays(1);

        List<FlightData> flightData = flightDataService.getFlightMonitoring(startDate, endDate, station);

        Integer i = 0; Integer j = 0;
        List<FlightDataMonitoring> flightDataMonitorings = new ArrayList<FlightDataMonitoring>();
        FlightDataMonitoring flightDataMonitoring = new FlightDataMonitoring();
        List<FlightData> flightDataDetail = new ArrayList<FlightData>();

        if(flightData.isEmpty() || flightData == null){
            return flightDataMonitorings = null;
        }
        else {
            String locationCurrent = flightData.get(i).getHostPos();
            flightDataMonitoring.setHostPos(flightData.get(i).getHostPos());
            flightDataMonitoring.setStation(flightData.get(i).getStation());

            for (i=0; i < flightData.size(); i++){
                if (locationCurrent.equals(flightData.get(i).getHostPos())){
                    if (i == flightData.size() - 1){
                        //Add Data to List
                        flightDataDetail.add(flightData.get(i));
                        //Save Last List
                        flightDataMonitoring.setFlightData(flightDataDetail);
                        flightDataMonitorings.add(flightDataMonitoring);
                    }
                    else {
                        flightDataDetail.add(flightData.get(i));
                    }
                }
                else{
                    if (i == flightData.size() - 1){
                        //Add Before Data to List
                        flightDataMonitoring.setFlightData(flightDataDetail);
                        flightDataMonitorings.add(flightDataMonitoring);

                        //Set New List
                        flightDataMonitoring = new FlightDataMonitoring();
                        flightDataDetail = new ArrayList<FlightData>();
                        flightDataMonitoring.setHostPos(flightData.get(i).getHostPos());
                        flightDataMonitoring.setStation(flightData.get(i).getStation());
                        flightDataDetail.add(flightData.get(i));
                        //Save Last List
                        flightDataMonitoring.setFlightData(flightDataDetail);
                        flightDataMonitorings.add(flightDataMonitoring);
                    }
                    else {
                        //Add Before Data to List
                        flightDataMonitoring.setFlightData(flightDataDetail);
                        flightDataMonitorings.add(flightDataMonitoring);

                        //Set New List
                        flightDataMonitoring = new FlightDataMonitoring();
                        flightDataDetail = new ArrayList<FlightData>();
                        flightDataMonitoring.setHostPos(flightData.get(i).getHostPos());
                        flightDataMonitoring.setStation(flightData.get(i).getStation());
                        flightDataDetail.add(flightData.get(i));
                    }
                }
                locationCurrent = flightData.get(i).getHostPos();
            }
            return flightDataMonitorings;
        }
    }

    @GetMapping("/find/{id}")
    public FlightData getById(@PathVariable(value = "id") String Id) {
        return (FlightData) flightDataService.findById(Id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable(value = "id") String  id) {

        FlightData flightData = (FlightData) flightDataService.findById(id);
        flightData.setActive(ActiveEnum.N);
        flightDataService.saveOrUpdate(flightData);
        //flightDataService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
