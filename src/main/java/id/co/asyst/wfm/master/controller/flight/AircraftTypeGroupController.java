package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftTypeGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.AircraftTypeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/aircraft-type-group")
public class AircraftTypeGroupController {

    @Autowired
    AircraftTypeGroupService aircraftTypeGroupService;

    @GetMapping("/list")
    public List<AircraftTypeGroup> getAll() {
        return (List<AircraftTypeGroup>) aircraftTypeGroupService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"acTypeGroupCode"})
    public List<AircraftTypeGroup> getSuggest(@RequestParam("acTypeGroupCode") String acTypeCode) {
        return aircraftTypeGroupService.findByAcTypeCodeList(acTypeCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"acTypeGroupCode"})
    public Page<AircraftTypeGroup> getAll(@RequestParam("acTypeGroupCode") String acTypeCode, Pageable pageable) {
        return aircraftTypeGroupService.findByActTypeCodePage(acTypeCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"acTypeGroupCode"})
    public Page<AircraftTypeGroup> getAllDelete(@RequestParam("acTypeGroupCode") String acTypeCode, Pageable pageable) {
        return aircraftTypeGroupService.findByActTypeCodePage(acTypeCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody AircraftTypeGroup aircraftTypeGroup) {

        Integer aircraftTypeGroupCheck = aircraftTypeGroupService.countByAcTypeGroupCode(aircraftTypeGroup.getAcTypeGroupCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if (aircraftTypeGroupCheck > 0){
            responseProfile = new ResponseProfile("40009","Aircraft Type Group Code Already Exist","Create Aircraft Type Group");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            aircraftTypeGroup.setAcTypeGroupCode(aircraftTypeGroup.getAcTypeGroupCode().toUpperCase());
            aircraftTypeGroupService.saveOrUpdate(aircraftTypeGroup);

            responseProfile = new ResponseProfile("00000","Success","Create Aircraft Type Group", aircraftTypeGroup);
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public AircraftTypeGroup getById(@PathVariable(value = "id") String acTypeCode) {
        return (AircraftTypeGroup) aircraftTypeGroupService.findById(acTypeCode);
    }

    @PutMapping("/update/{id}")
    public ResponseProfile update(@PathVariable(value = "id") String acTypeCode,
                               @Valid @RequestBody AircraftTypeGroup aircraftTypeGroupDetails) {

        AircraftTypeGroup aircraftTypeGroup = (AircraftTypeGroup) aircraftTypeGroupService.findById(acTypeCode);

        aircraftTypeGroup.setAcTypeGroupDesc(aircraftTypeGroupDetails.getAcTypeGroupDesc());
        aircraftTypeGroup.setActive(aircraftTypeGroupDetails.getActive());

        aircraftTypeGroupService.saveOrUpdate(aircraftTypeGroup);
        return new ResponseProfile("00000","Success","Update Aircraft Type");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  functionId) {

        AircraftTypeGroup aircraftTypeGroup = (AircraftTypeGroup) aircraftTypeGroupService.findById(functionId);
        ActiveEnum active = ActiveEnum.N;
        aircraftTypeGroup.setActive(active);
        aircraftTypeGroupService.saveOrUpdate(aircraftTypeGroup);
        //aircraftTypeGroupService.deleteById(functionId);
        return ResponseEntity.ok().build();
    }
}
