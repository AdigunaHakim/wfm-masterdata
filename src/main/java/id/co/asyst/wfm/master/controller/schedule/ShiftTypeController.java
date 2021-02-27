package id.co.asyst.wfm.master.controller.schedule;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Branch;
import id.co.asyst.wfm.master.model.schedule.ShiftType;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.schedule.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/shift-type")
public class ShiftTypeController {

    @Autowired
    ShiftTypeService shiftTypeService;

    @GetMapping("/list")
    public List<ShiftType> getAllBranch() {
        return (List<ShiftType>) shiftTypeService.findAll();
    }

    @GetMapping(value = "/list", params = {"shiftTypeCode"})
    public Page<ShiftType> getAllBranch(@RequestParam("shiftTypeCode") String shiftTypeCode, Pageable pageable) {
        return shiftTypeService.findByBranchCodeContains(shiftTypeCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"shiftTypeCode"})
    public Page<ShiftType> getAllBranchDelete(@RequestParam("shiftTypeCode") String shiftTypeCode, Pageable pageable) {
        return shiftTypeService.findByBranchCodeContains(shiftTypeCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBranch(@Valid @RequestBody ShiftType shiftType) {
        Integer shiftTypeCodeCheck = shiftTypeService.countByShfitTypeCode(shiftType.getShiftTypeCode().toUpperCase());
        Integer publishNameCheck = shiftTypeService.countByPublishName(shiftType.getPublishName().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity ;
        responseEntity = null;

        if( shiftTypeCodeCheck > 0){
            responseProfile = new ResponseProfile("40009","Shift Type Code Already Exist","Create Shift Type");
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.BAD_REQUEST);

        }
        else if( publishNameCheck > 0){
            responseProfile = new ResponseProfile("40009","Publish Name Must Be Unique","Create Shift Type");
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.BAD_REQUEST);
        }
        else{
            if (shiftType.getNormalStarttime().isAfter(shiftType.getNormalEndtime())){
                shiftType.setShiftIndicator(1);
            }
            else {
                shiftType.setShiftIndicator(0);
            }
            shiftType.setShiftTypeCode(shiftType.getShiftTypeCode().toUpperCase());
            shiftType.setPublishName(shiftType.getPublishName().toUpperCase());
            shiftTypeService.saveOrUpdate(shiftType);

            responseProfile = new ResponseProfile("00000","Success","Create Shift Type",shiftType);
            responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public ShiftType getBranchById(@PathVariable(value = "id") String shiftTypeId) {
        return (ShiftType) shiftTypeService.findById(shiftTypeId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBranch(@PathVariable(value = "id") String shiftTypeId,
                               @Valid @RequestBody ShiftType shiftTypeDetails) {

        ShiftType shiftType = (ShiftType) shiftTypeService.findById(shiftTypeId);

        shiftType.setPublishName(shiftTypeDetails.getPublishName().toUpperCase());
        shiftType.setNormalStarttime(shiftTypeDetails.getNormalStarttime());
        shiftType.setNormalEndtime(shiftTypeDetails.getNormalEndtime());
        shiftType.setOvertimeStarttime(shiftTypeDetails.getOvertimeStarttime());
        shiftType.setOvertimeEndtime(shiftTypeDetails.getOvertimeEndtime());
        shiftType.setActive(shiftTypeDetails.getActive());

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if (shiftType.getNormalStarttime().isAfter(shiftType.getNormalEndtime())){
            shiftType.setShiftIndicator(1);
        }
        else {
            shiftType.setShiftIndicator(0);
        }

        shiftTypeService.saveOrUpdate(shiftType);
        responseProfile = new ResponseProfile("00000","Success","Create Shift Type",shiftType);
        responseEntity = new ResponseEntity<>(responseProfile,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable(value = "id") String  branchId) {

        ShiftType shiftType = (ShiftType) shiftTypeService.findById(branchId);
        shiftType.setActive(ActiveEnum.N);
        shiftTypeService.saveOrUpdate(shiftType);
        //shiftTypeService.deleteById(branchId);
        return ResponseEntity.ok().build();
    }
}
