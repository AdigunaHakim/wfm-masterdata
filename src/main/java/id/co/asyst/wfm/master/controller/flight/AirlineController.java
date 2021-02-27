package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.AirlineTransactionGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.AirlineGroupService;
import id.co.asyst.wfm.master.service.flight.AirlineService;
import id.co.asyst.wfm.master.service.flight.AirlineTransactionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/airline")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirlineGroupService airlineGroupService;

    @Autowired
    AirlineTransactionGroupService airlineTransactionGroupService;

    @GetMapping("/list")
    public List<Airline> getAll() {
        return (List<Airline>) airlineService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"airlineCode"})
    public List<Airline> getSuggest(@RequestParam("airlineCode") String airlineCode) {
        return airlineService.findByAirlineCodeList(airlineCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"airlineCode"})
    public Page<Airline> getAll(@RequestParam("airlineCode") String airlineCode, Pageable pageable) {
        return airlineService.findByAirlineCodePage(airlineCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"airlineCode"})
    public Page<Airline> getAllDelete(@RequestParam("airlineCode") String airlineCode, Pageable pageable) {
        return airlineService.findByAirlineCodePage(airlineCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Airline airlineDetails) {

        Integer airlineCheck = airlineService.countById(airlineDetails.getAirlineCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if(airlineCheck > 0){
            responseProfile = new ResponseProfile("40009","Airline Code Already Exist","Create Airline");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            Airline airline = new Airline();
            airline.setAirlineCode(airlineDetails.getAirlineCode().toUpperCase());
            airline.setAirlineDesc(airlineDetails.getAirlineDesc());
            airline.setIcaoCode(airlineDetails.getIcaoCode());
            airline.setActive(airlineDetails.getActive());
            airlineService.saveOrUpdate(airline);

            responseProfile = new ResponseProfile("00000","Success","Create Airline",airline);
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public Airline getById(@PathVariable(value = "id") String airlineCode) {
        return (Airline) airlineService.findById(airlineCode);
    }

    @PutMapping("/update/{id}")
    public ResponseProfile update(@PathVariable(value = "id") String acTypeCode,
                               @Valid @RequestBody Airline airlineDetails) {

        Airline airline = (Airline) airlineService.findById(airlineDetails.getAirlineCode());

        airline.setAirlineCode(airlineDetails.getAirlineCode());
        airline.setAirlineDesc(airlineDetails.getAirlineDesc());
        airline.setIcaoCode(airlineDetails.getIcaoCode());
        airline.setActive(airlineDetails.getActive());

        airlineService.saveOrUpdate(airline);
        return new ResponseProfile("00000","Success","Update Airline");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  airlineCode) {

        Airline airline = (Airline) airlineService.findById(airlineCode);
        ActiveEnum active = ActiveEnum.N;
        airline.setActive(active);
        airlineService.saveOrUpdate(airline);
        /*List<AirlineTransactionGroup> airlineTransactionGroup = airlineTransactionGroupService.findByAirline(airlineCode);
        Integer rows = airlineTransactionGroup.size();
        for (int i=0; i<rows; i++){
            airlineTransactionGroup.get(i).setActive(active);
            airlineTransactionGroupService.saveOrUpdate(airlineTransactionGroup.get(i));
        }*/
        //airlineService.deleteById(airlineCode);
        //airlineTransactionGroupService.deleteByAirline(airlineCode);
        return ResponseEntity.ok().build();
    }
}
