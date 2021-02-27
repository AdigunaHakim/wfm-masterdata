package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import id.co.asyst.wfm.master.model.flight.AirlineTransactionGroup;
import id.co.asyst.wfm.master.payload.flight.AirlineTransactionGroupInsert;
import id.co.asyst.wfm.master.payload.flight.AirlineTransactionGroupProfile;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.AirlineGroupService;
import id.co.asyst.wfm.master.service.flight.AirlineService;
import id.co.asyst.wfm.master.service.flight.AirlineTransactionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/master/airline-transaction-group")
public class AirlineTransactionGroupController {

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirlineGroupService airlineGroupService;

    @Autowired
    AirlineTransactionGroupService airlineTransactionGroupService;

    @GetMapping("/list")
    public List<AirlineTransactionGroup> getAll() {
        return (List<AirlineTransactionGroup>) airlineTransactionGroupService.findAll();
    }

    @PostMapping("/set/airline-group")
    public ResponseProfile createByFunction(@Valid @RequestBody AirlineTransactionGroupInsert airlineTransactionGroupDetail) {

        /*Integer countCheck = airlineGroupService.countByAirlineGroupCode(airlineTransactionGroupDetail.getAirlineGroupCode().toUpperCase());
        String[] airline = airlineTransactionGroupDetail.getAirlineCode();

        if(countCheck == 0){
            AirlineGroup airlineGroupCreate = new AirlineGroup();
            airlineGroupCreate.setAirlineGroupCode(airlineTransactionGroupDetail.getAirlineGroupCode().toUpperCase());
            airlineGroupCreate.setAirlineGroupDesc(airlineTransactionGroupDetail.getAirlineGroupDesc());
            airlineGroupCreate.setActive(airlineTransactionGroupDetail.getActive());

            airlineGroupService.saveOrUpdate(airlineGroupCreate);
        }*/

        String[] airline = airlineTransactionGroupDetail.getAirlineCode();
        airlineTransactionGroupService.deletebyAirlineGroup(airlineTransactionGroupDetail.getAirlineGroupCode().toUpperCase());
        AirlineGroup airlineGroupCheck = (AirlineGroup) airlineGroupService.findById(airlineTransactionGroupDetail.getAirlineGroupCode().toUpperCase());

        int i = 0;
        while(i < airline.length){

            AirlineTransactionGroup airlineTransactionGroup = new AirlineTransactionGroup();
            Airline airlineInsert = (Airline) airlineService.findById(airline[i].toUpperCase());
            AirlineGroup airlineGroup = (AirlineGroup) airlineGroupService.findById(airlineTransactionGroupDetail.getAirlineGroupCode().toUpperCase());
            airlineTransactionGroup.setAirline(airlineInsert);
            airlineTransactionGroup.setAirlineGroup(airlineGroup);
            airlineTransactionGroup.setActive(airlineTransactionGroupDetail.getActive());

            airlineTransactionGroupService.saveOrUpdate(airlineTransactionGroup);
            i ++;
        }

        airlineGroupCheck.setAirlineGroupDesc(airlineTransactionGroupDetail.getAirlineGroupDesc());
        airlineGroupService.saveOrUpdate(airlineGroupCheck);
        return new ResponseProfile("00000","Success","Update Airline Group");
    }

    @GetMapping("/find/{id}")
    public AirlineTransactionGroup getById(@PathVariable(value = "id") Long id) {
        return (AirlineTransactionGroup) airlineTransactionGroupService.findById(id);
    }

    @GetMapping(value = "/find", params = {"airlineGroupCode"})
    public List<AirlineTransactionGroupProfile> getByFunction(@RequestParam("airlineGroupCode") String airlineGroupCode) {
        List<Object[]> objects = (List<Object[]>) airlineTransactionGroupService.findByAirlineGroup(airlineGroupCode);

        return objects.stream().map(o-> new AirlineTransactionGroupProfile((String)o[1],(String)o[0])).collect(Collectors.toList());
    }

    @GetMapping(value = "/selected/airline", params = {"airlineGroupCode","airlineCode"})
    public List<Airline> getByFunction(@RequestParam("airlineGroupCode") String airlineGroupCode, @RequestParam("airlineCode") String airlineCode) {
        return airlineTransactionGroupService.findBySelectedAirline(airlineGroupCode, airlineCode);
    }

    @GetMapping(value = "/selected/airline-group", params = {"airlineCode","airlineGroupCode"})
    public List<AirlineGroup> getAirlineGroup(@RequestParam("airlineGroupCode") String airlineGroupCode, @RequestParam("airlineCode") String airlineCode) {
        return airlineTransactionGroupService.findBySelectedAirlineGroup(airlineCode, airlineGroupCode);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value = "id") Long id) {

        AirlineTransactionGroup airlineTransactionGroup = (AirlineTransactionGroup) airlineTransactionGroupService.findById(id);
        airlineTransactionGroup.setActive(ActiveEnum.N);
        airlineTransactionGroupService.saveOrUpdate(airlineTransactionGroup);
        return ResponseEntity.ok().build();
    }
}
