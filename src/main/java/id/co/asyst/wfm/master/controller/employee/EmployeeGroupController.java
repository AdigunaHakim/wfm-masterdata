package id.co.asyst.wfm.master.controller.employee;


import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Branch;
import id.co.asyst.wfm.master.model.employee.EmployeeGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.employee.BranchService;
import id.co.asyst.wfm.master.service.employee.EmployeeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/employee-group")
public class EmployeeGroupController {

    @Autowired
    EmployeeGroupService employeeGroupRepository;

    @Autowired
    BranchService branchRepository;

    @GetMapping("/list")
    public List<EmployeeGroup> getAllEmployeeGroup() {
        return (List<EmployeeGroup>) employeeGroupRepository.findAll();
    }

    @GetMapping(value = "/list", params = {"employeeGroupCode"})
    public Page<EmployeeGroup> searchAllEmployeeGroup(@RequestParam("employeeGroupCode") String code, Pageable pageable) {
        return employeeGroupRepository.findByEmployeeGroupCodeContains(code, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"employeeGroupCode"})
    public Page<EmployeeGroup> searchAllEmployeeGroupDelete(@RequestParam("employeeGroupCode") String code, Pageable pageable) {
        return employeeGroupRepository.findByEmployeeGroupCodeContains(code, ActiveEnum.N, pageable);
    }

    @PostMapping("/create/{branchCode}")
    public ResponseEntity<?> createEmployeeGroup(@PathVariable (value = "branchCode") String branchCode,
                                             @Valid @RequestBody EmployeeGroup employeeGroup) {

        Integer employeeGroupCheck = employeeGroupRepository.findByEmployeeGroupCode(employeeGroup.getEmployeeGroupCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if (employeeGroupCheck > 0){
            responseProfile = new ResponseProfile("40009","Employee Group Code Already Exist","Create Employee Group");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            Branch branch = (Branch) branchRepository.findById(branchCode);
            employeeGroup.setBranchs(branch);
            employeeGroup.setEmployeeGroupCode(employeeGroup.getEmployeeGroupCode().toUpperCase());
            employeeGroupRepository.saveOrUpdate(employeeGroup);

            responseProfile = new ResponseProfile("00000","Success","Create Employee Group");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/find/{employeeGroupCode}/")
    public EmployeeGroup getEmployeeGroupById(@PathVariable(value = "employeeGroupCode") String employeeGroupId) {
        return (EmployeeGroup) employeeGroupRepository.findById(employeeGroupId);
    }

    @PutMapping("/update/{employeeGroupCode}/{branchCode}")
    public ResponseEntity<?> updateEmployeeGroup(@PathVariable(value = "employeeGroupCode") String employeeGroupId,
                                             @PathVariable(value = "branchCode") String branchCode,
                                             @Valid @RequestBody EmployeeGroup employeeGroupDetails) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        EmployeeGroup employeeGroup = (EmployeeGroup) employeeGroupRepository.findById(employeeGroupId);
        Branch branch = (Branch) branchRepository.findById(branchCode);
        employeeGroup.setEmployeeGroupCode(employeeGroupDetails.getEmployeeGroupCode());
        employeeGroup.setEmployeeGroupDesc(employeeGroupDetails.getEmployeeGroupDesc());
        employeeGroup.setBranchs(branch);
        employeeGroup.setActive(employeeGroupDetails.getActive());
        employeeGroupRepository.saveOrUpdate(employeeGroup);

        responseProfile = new ResponseProfile("00000","Success","Update Employee Group");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping("/delete/{employeeGroupCode}")
    public ResponseEntity<?> deleteEmployeeGroup(@PathVariable(value = "employeeGroupCode") String employeeGroupId) {

        EmployeeGroup employeeGroup = (EmployeeGroup) employeeGroupRepository.findById(employeeGroupId);
        employeeGroup.setActive(ActiveEnum.N);
        employeeGroupRepository.saveOrUpdate(employeeGroup);
        //employeeGroupRepository.deleteById(employeeGroupId);
        return ResponseEntity.ok().build();
    }
}