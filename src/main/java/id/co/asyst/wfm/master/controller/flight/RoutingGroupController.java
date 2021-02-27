package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.RoutingGroup;
import id.co.asyst.wfm.master.model.flight.RoutingTransactionGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.RoutingGroupService;
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
@RequestMapping("/master/routing-group")
public class RoutingGroupController {

    @Autowired
    RoutingGroupService routingGroupService;

    @Autowired
    RoutingTransactionGroupService routingTransactionGroupService;

    @GetMapping("/list")
    public List<RoutingGroup> getAll() {
        return (List<RoutingGroup>) routingGroupService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"routingGroupCode"})
    public List<RoutingGroup> getSuggest(@RequestParam("routingGroupCode") String routingGroupCode) {
        return routingGroupService.findByRoutingGroupCodeList(routingGroupCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"routingGroupCode"})
    public Page<RoutingGroup> getAll(@RequestParam("routingGroupCode") String routingGroupCode, Pageable pageable) {
        return routingGroupService.findByRoutingGroupCodePage(routingGroupCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"routingGroupCode"})
    public Page<RoutingGroup> getAllDelete(@RequestParam("routingGroupCode") String routingGroupCode, Pageable pageable) {
        return routingGroupService.findByRoutingGroupCodePage(routingGroupCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody RoutingGroup routingGroup) {

        Integer routingGroupCheck = routingGroupService.countByRoutingGroupCode(routingGroup.getRoutingGroupCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if (routingGroupCheck > 0){
            responseProfile = new ResponseProfile("40009","Routing Group Code Already Exist","Create Routing Group");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            routingGroup.setRoutingGroupCode(routingGroup.getRoutingGroupCode().toUpperCase());
            routingGroupService.saveOrUpdate(routingGroup);

            responseProfile = new ResponseProfile("00000","Success","Create Routing Group",routingGroup);
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public RoutingGroup getById(@PathVariable(value = "id") String routingGroupCode) {
        return (RoutingGroup) routingGroupService.findById(routingGroupCode);
    }

    @PutMapping("/update/{id}")
    public ResponseProfile update(@PathVariable(value = "id") String routingGroupCode,
                                    @Valid @RequestBody RoutingGroup routingGroupDetails) {

        RoutingGroup routingGroup = (RoutingGroup) routingGroupService.findById(routingGroupCode);

        routingGroup.setRoutingGroupDesc(routingGroupDetails.getRoutingGroupDesc());
        routingGroup.setActive(routingGroupDetails.getActive());

        routingGroupService.saveOrUpdate(routingGroup);
        return new ResponseProfile("00000","Success","Update Routing Group");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  routingGroupCode) {

        RoutingGroup routingGroup = (RoutingGroup) routingGroupService.findById(routingGroupCode);
        routingGroup.setActive(ActiveEnum.N);
        routingGroupService.saveOrUpdate(routingGroup);
        /*List<RoutingTransactionGroup> routingTransactionGroup = routingTransactionGroupService.findByRoutingGroup(routingGroupCode);
        for(int i =0; i<routingTransactionGroup.size(); i++){
            routingTransactionGroup.get(i).setActive(ActiveEnum.N);
            routingTransactionGroupService.saveOrUpdate(routingTransactionGroup.get(i));
        }*/
        //routingGroupService.deleteById(routingGroupCode);
        //routingTransactionGroupService.deletebyRoutingGroup(routingGroupCode);
        return ResponseEntity.ok().build();
    }
}
