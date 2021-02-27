package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import id.co.asyst.wfm.master.model.flight.AirlineTransactionGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.AirlineGroupService;
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
@RequestMapping("/master/airline-group")
public class AirlineGroupController {

    @Autowired
    AirlineGroupService airlineGroupService;

    @Autowired
    AirlineTransactionGroupService airlineTransactionGroupService;

    @GetMapping("/list")
    public List<AirlineGroup> getAll() {
        return (List<AirlineGroup>) airlineGroupService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"airlineGroupCode"})
    public List<AirlineGroup> getSuggest(@RequestParam("airlineGroupCode") String airlineGroupCode) {
        return airlineGroupService.findByAirlineGroupCodeList(airlineGroupCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"airlineGroupCode"})
    public Page<AirlineGroup> getAll(@RequestParam("airlineGroupCode") String airlineGroupCode, Pageable pageable) {
        return airlineGroupService.findByAirlineGroupCodePage(airlineGroupCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"airlineGroupCode"})
    public Page<AirlineGroup> getAllDelete(@RequestParam("airlineGroupCode") String airlineGroupCode, Pageable pageable) {
        return airlineGroupService.findByAirlineGroupCodePage(airlineGroupCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody AirlineGroup airlineGroup) {

        Integer airlineGroupCheck = airlineGroupService.countByAirlineGroupCode(airlineGroup.getAirlineGroupCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if(airlineGroupCheck > 0){
            responseProfile = new ResponseProfile("40009","Airline Group Code Already Exist","Create Airline Group");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            airlineGroup.setAirlineGroupCode(airlineGroup.getAirlineGroupCode().toUpperCase());
            airlineGroupService.saveOrUpdate(airlineGroup);

            responseProfile = new ResponseProfile("00000","Success","Create Airline Group",airlineGroup);
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public AirlineGroup getById(@PathVariable(value = "id") String airlineGroupCode) {
        return (AirlineGroup) airlineGroupService.findById(airlineGroupCode);
    }

    @PutMapping("/update/{id}")
    public ResponseProfile update(@PathVariable(value = "id") String airlineGroupCode,
                                @Valid @RequestBody AirlineGroup airlineGroupDetails) {

        AirlineGroup airlineGroup = (AirlineGroup) airlineGroupService.findById(airlineGroupCode);

        airlineGroup.setAirlineGroupDesc(airlineGroupDetails.getAirlineGroupDesc());
        airlineGroup.setActive(airlineGroupDetails.getActive());

        airlineGroupService.saveOrUpdate(airlineGroup);
        return new ResponseProfile("00000","Success","Update Airline Group");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  airlineGroupCode) {

        AirlineGroup airlineGroup = (AirlineGroup) airlineGroupService.findById(airlineGroupCode);
        ActiveEnum active = ActiveEnum.N;
        airlineGroup.setActive(active);
        airlineGroupService.saveOrUpdate(airlineGroup);
        /*List<AirlineTransactionGroup> airlineTransactionGroup = airlineTransactionGroupService.findByAirline(airlineGroupCode);
        Integer rows = airlineTransactionGroup.size();
        for (int i=0; i<rows; i++){
            airlineTransactionGroup.get(i).setActive(active);
            airlineTransactionGroupService.saveOrUpdate(airlineTransactionGroup.get(i));
        }*/
        //airlineGroupService.deleteById(airlineGroupCode);
        //airlineTransactionGroupService.deletebyAirlineGroup(airlineGroupCode);
        return ResponseEntity.ok().build();
    }
}
