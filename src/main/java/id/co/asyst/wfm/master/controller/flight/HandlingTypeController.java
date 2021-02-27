package id.co.asyst.wfm.master.controller.flight;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.HandlingType;
import id.co.asyst.wfm.master.service.flight.HandlingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/master/handling-type")
public class HandlingTypeController {

    @Autowired
    HandlingTypeService handlingTypeService;

    @GetMapping("/list")
    public List<HandlingType> getAll() {
        return (List<HandlingType>) handlingTypeService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"serviceTypeCode"})
    public List<HandlingType> getSuggest(@RequestParam("serviceTypeCode") String serviceTypeCode) {
        return handlingTypeService.findByHandlingTypeCodeList(serviceTypeCode);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"routingGroupCode"})
    public Page<HandlingType> getAll(@RequestParam("routingGroupCode") String serviceTypeCode, Pageable pageable) {
        return handlingTypeService.findByHandlingTypeCodePage(serviceTypeCode, pageable);
    }

    @PostMapping("/create")
    public HandlingType create(@Valid @RequestBody HandlingType handlingType) {
        handlingType.setHandlingTypeCode(handlingType.getHandlingTypeCode().toUpperCase());
        return (HandlingType) handlingTypeService.saveOrUpdate(handlingType);
    }

    @GetMapping("/find/{id}")
    public HandlingType getById(@PathVariable(value = "id") String serviceTypeCode) {
        return (HandlingType) handlingTypeService.findById(serviceTypeCode);
    }

    @PutMapping("/update/{id}")
    public HandlingType update(@PathVariable(value = "id") String serviceTypeCode,
                               @Valid @RequestBody HandlingType handlingTypeDetails) {

        HandlingType handlingType = (HandlingType) handlingTypeService.findById(serviceTypeCode);

        handlingType.setHandlingTypeDesc(handlingTypeDetails.getHandlingTypeDesc());
        handlingType.setActive(handlingTypeDetails.getActive());

        return (HandlingType) handlingTypeService.saveOrUpdate(handlingType);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  functionId) {

        HandlingType handlingType = (HandlingType) handlingTypeService.findById(functionId);
        handlingType.setActive(ActiveEnum.N);
        handlingTypeService.saveOrUpdate(handlingType);
        return ResponseEntity.ok().build();
    }

}
