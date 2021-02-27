package id.co.asyst.wfm.master.controller.flight;


import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.*;
import id.co.asyst.wfm.master.payload.flight.AirlineTransactionGroupProfile;
import id.co.asyst.wfm.master.payload.flight.RoutingTransactionGroupInsert;
import id.co.asyst.wfm.master.payload.flight.RoutingTransactionGroupProfile;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/master/routing-transaction-group")
public class RoutingTransactionGroupController {

    @Autowired
    RoutingService routingService;

    @Autowired
    RoutingGroupService routingGroupService;

    @Autowired
    RoutingTransactionGroupService routingTransactionGroupService;

    @GetMapping("/list")
    public List<RoutingTransactionGroup> getAll() {
        return (List<RoutingTransactionGroup>) routingTransactionGroupService.findAll();
    }

    @PostMapping("/set/routing-group")
    public ResponseProfile createByRoutingGroup(@Valid @RequestBody RoutingTransactionGroupInsert routingTransactionGroupInsert) {

        /*Integer countCheck = routingGroupService.countByRoutingGroupCode(routingTransactionGroupInsert.getRoutingGroupCode().toUpperCase());
        String[] routeList = routingTransactionGroupInsert.getRoutingCode();

        if(countCheck == 0){
            RoutingGroup routingGroupCreate = new RoutingGroup();
            routingGroupCreate.setRoutingGroupCode(routingTransactionGroupInsert.getRoutingGroupCode().toUpperCase());
            routingGroupCreate.setRoutingGroupDesc(routingTransactionGroupInsert.getRoutingGroupDesc());
            routingGroupCreate.setActive(routingTransactionGroupInsert.getActive());

            routingGroupService.saveOrUpdate(routingGroupCreate);
        }*/

        String[] routeList = routingTransactionGroupInsert.getRoutingCode();
        routingTransactionGroupService.deletebyRoutingGroup(routingTransactionGroupInsert.getRoutingGroupCode().toUpperCase());
        RoutingGroup routingGroupCheck = (RoutingGroup) routingGroupService.findById(routingTransactionGroupInsert.getRoutingGroupCode().toUpperCase());

        int i = 0;
        while(i < routeList.length){

            RoutingTransactionGroup routingTransactionGroup = new RoutingTransactionGroup();
            Routing routingInsert = (Routing) routingService.findById(routeList[i].toUpperCase());
            RoutingGroup routingGroup = (RoutingGroup) routingGroupService.findById(routingTransactionGroupInsert.getRoutingGroupCode().toUpperCase());
            routingTransactionGroup.setRouting(routingInsert);
            routingTransactionGroup.setRoutingGroup(routingGroup);
            routingTransactionGroup.setActive(routingTransactionGroupInsert.getActive());

            routingTransactionGroupService.saveOrUpdate(routingTransactionGroup);
            i ++;
        }

        routingGroupCheck.setRoutingGroupDesc(routingTransactionGroupInsert.getRoutingGroupDesc());
        routingGroupService.saveOrUpdate(routingGroupCheck);

        return new ResponseProfile("00000","Success","Update Routing Group");
    }

    @GetMapping("/find/{id}")
    public RoutingTransactionGroup getById(@PathVariable(value = "id") Long id) {
        return (RoutingTransactionGroup) routingTransactionGroupService.findById(id);
    }

    @GetMapping(value = "/find", params = {"routingGroupCode"})
    public List<RoutingTransactionGroupProfile> getByFunction(@RequestParam("routingGroupCode") String routingGroupCode) {
        List<Object[]> objects = routingTransactionGroupService.findByRoutingGroup(routingGroupCode);

        return objects.stream().map(o-> new RoutingTransactionGroupProfile((String)o[1],(String)o[0])).collect(Collectors.toList());
    }

    @GetMapping(value = "/selected/routing", params = {"routingGroupCode","routingCode"})
    public List<Routing> getRouting(@RequestParam("routingGroupCode") String routingGroupCode, @RequestParam("routingCode") String routingCode) {
        return routingTransactionGroupService.findBySelectedRouting(routingGroupCode, routingCode);

    }

    @GetMapping(value = "/selected/routing-group", params = {"routingGroupCode","routingCode"})
    public List<RoutingGroup> getRoutingGroup(@RequestParam("routingGroupCode") String routingGroupCode, @RequestParam("routingCode") String routingCode) {
        return routingTransactionGroupService.findBySelectedRoutingGroup(routingCode, routingGroupCode);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value = "id") Long id) {

        RoutingTransactionGroup routingTransactionGroup = (RoutingTransactionGroup) routingTransactionGroupService.findById(id);
        routingTransactionGroup.setActive(ActiveEnum.N);
        routingTransactionGroupService.saveOrUpdate(routingTransactionGroup);
        //routingTransactionGroupService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
