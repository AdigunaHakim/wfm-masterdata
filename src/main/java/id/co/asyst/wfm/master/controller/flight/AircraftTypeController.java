package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import id.co.asyst.wfm.master.model.flight.AircraftTypeGroup;
import id.co.asyst.wfm.master.payload.flight.AircraftTypeInsert;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.flight.AircraftTypeGroupService;
import id.co.asyst.wfm.master.service.flight.AircraftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/aircraft-type")
public class AircraftTypeController {

    @Autowired
    AircraftTypeService aircraftTypeService;

    @Autowired
    AircraftTypeGroupService aircraftTypeGroupService;

    @GetMapping("/list")
    public List<AircraftType> getAll() {
        return (List<AircraftType>) aircraftTypeService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"acTypeCode"})
    public List<AircraftType> getSuggest(@RequestParam("acTypeCode") String acTypeCode) {
        return aircraftTypeService.findByAircraftTypeCodeList(acTypeCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"acTypeCode"})
    public Page<AircraftType> getAll(@RequestParam("acTypeCode") String acTypeCode, Pageable pageable) {
        return aircraftTypeService.findByAircraftTypeCodePage(acTypeCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"acTypeCode"})
    public Page<AircraftType> getAllDelete(@RequestParam("acTypeCode") String acTypeCode, Pageable pageable) {
        return aircraftTypeService.findByAircraftTypeCodePage(acTypeCode, ActiveEnum.N, pageable);
    }

    @GetMapping(value = "/selected", params = {"acTypeCode","acTypeGroupCode"})
    public List<AircraftType> getAll(@RequestParam("acTypeGroupCode") String acTypeGroupCode, @RequestParam("acTypeCode") String acTypeCode) {
        return aircraftTypeService.findBySelectAircraft(acTypeGroupCode, acTypeCode);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody AircraftTypeInsert aircraftTypeDetails) {

        Integer aircraftTypeCheck = aircraftTypeService.countById(aircraftTypeDetails.getAcTypeCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;
        if (aircraftTypeCheck > 0){
            responseProfile = new ResponseProfile("40009","Aircraft Type Code Already Exist","Create Aircraft Type");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            AircraftType aircraftType = new AircraftType();
            AircraftTypeGroup aircraftTypeGroup = (AircraftTypeGroup) aircraftTypeGroupService.findById(aircraftTypeDetails.getAcTypeGroupCode());
            aircraftType.setAcTypeCode(aircraftTypeDetails.getAcTypeCode().toUpperCase());
            aircraftType.setAcTypeDesc(aircraftTypeDetails.getAcTypeDesc());
            aircraftType.setAircraftTypeGroup(aircraftTypeGroup);
            aircraftType.setActive(aircraftTypeDetails.getActive());
            aircraftTypeService.saveOrUpdate(aircraftType);

            responseProfile = new ResponseProfile("00000","Success","Create Airline",aircraftType);
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public AircraftType getById(@PathVariable(value = "id") String acTypeCode) {
        return (AircraftType) aircraftTypeService.findById(acTypeCode);
    }

    @PutMapping("/update/{id}")
    public ResponseProfile update(@PathVariable(value = "id") String acTypeCode,
                                    @Valid @RequestBody AircraftTypeInsert aircraftTypeDetails) {

        AircraftType aircraftType = (AircraftType) aircraftTypeService.findById(aircraftTypeDetails.getAcTypeCode());
        AircraftTypeGroup aircraftTypeGroup = (AircraftTypeGroup) aircraftTypeGroupService.findById(aircraftTypeDetails.getAcTypeGroupCode());

        aircraftType.setAcTypeCode(aircraftTypeDetails.getAcTypeCode());
        aircraftType.setAcTypeDesc(aircraftTypeDetails.getAcTypeDesc());
        aircraftType.setAircraftTypeGroup(aircraftTypeGroup);
        aircraftType.setActive(aircraftTypeDetails.getActive());

        aircraftTypeService.saveOrUpdate(aircraftType);
        return new ResponseProfile("00000","Success","Update Aircraft Type");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  functionId) {

        AircraftType aircraftType = (AircraftType) aircraftTypeService.findById(functionId);
        ActiveEnum active = ActiveEnum.N;
        aircraftType.setActive(active);
        aircraftTypeService.saveOrUpdate(aircraftType);
        //aircraftTypeService.deleteById(functionId);
        return ResponseEntity.ok().build();
    }
}
