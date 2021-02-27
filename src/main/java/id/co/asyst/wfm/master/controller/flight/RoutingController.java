package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Routing;
import id.co.asyst.wfm.master.model.flight.RoutingTransactionGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.RoutingGroupService;
import id.co.asyst.wfm.master.service.flight.RoutingService;
import id.co.asyst.wfm.master.service.flight.RoutingTransactionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/routing")
public class RoutingController {

    @Autowired
    RoutingService routingService;

    @Autowired
    RoutingGroupService routingGroupService;

    @Autowired
    RoutingTransactionGroupService routingTransactionGroupService;

    @GetMapping("/list")
    public List<Routing> getAll() {
        return (List<Routing>) routingService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"routingCode"})
    public List<Routing> getSuggest(@RequestParam("routingCode") String routingCode) {
        return routingService.findByRoutingCodeList(routingCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"routingCode"})
    public Page<Routing> getAll(@RequestParam("routingCode") String routingCode, Pageable pageable) {
        return routingService.findByRoutingCodePage(routingCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"routingCode"})
    public Page<Routing> getAllDelete(@RequestParam("routingCode") String routingCode, Pageable pageable) {
        return routingService.findByRoutingCodePage(routingCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Routing routingInsertDetails) {

        Integer routingCheck = routingService.countById(routingInsertDetails.getRoutingCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if(routingCheck > 0){
            responseProfile = new ResponseProfile("40009","Routing Code Already Exist","Create Routing");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            Routing routing = new Routing();
            routing.setRoutingCode(routingInsertDetails.getRoutingCode().toUpperCase());
            routing.setRoutingDesc(routingInsertDetails.getRoutingDesc());
            routing.setIataCityCode(routingInsertDetails.getIataCityCode());
            routing.setIcaoAirportCode(routingInsertDetails.getIcaoAirportCode());
            routing.setActive(routingInsertDetails.getActive());
            routingService.saveOrUpdate(routing);

            responseProfile = new ResponseProfile("00000","Success","Create Routing",routing);
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public Routing getById(@PathVariable(value = "id") String routingCode) {
        return (Routing) routingService.findById(routingCode);
    }

    @PutMapping("/update/{id}")
    public ResponseProfile update(@PathVariable(value = "id") String routingCode,
                               @Valid @RequestBody Routing routingInsertDetails) {

        Routing routing = (Routing) routingService.findById(routingCode);

        routing.setRoutingCode(routingInsertDetails.getRoutingCode());
        routing.setRoutingDesc(routingInsertDetails.getRoutingDesc());
        routing.setIataCityCode(routingInsertDetails.getIataCityCode());
        routing.setIcaoAirportCode(routingInsertDetails.getIcaoAirportCode());
        routing.setActive(routingInsertDetails.getActive());

        routingService.saveOrUpdate(routing);
        return new ResponseProfile("00000","Success","Update Routing");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String routingCode) {

        Routing routing = (Routing) routingService.findById(routingCode);
        routing.setActive(ActiveEnum.N);
        routingService.saveOrUpdate(routing);
        /*List<RoutingTransactionGroup> routingTransactionGroup = routingTransactionGroupService.findByRouting(routingCode);
        for(int i =0; i<routingTransactionGroup.size(); i++){
            routingTransactionGroup.get(i).setActive(ActiveEnum.N);
            routingTransactionGroupService.saveOrUpdate(routingTransactionGroup.get(i));
        }*/
        //routingService.deleteById(routingCode);
        //routingTransactionGroupService.deleteByRouting(routingCode);
        return ResponseEntity.ok().build();
    }
}
