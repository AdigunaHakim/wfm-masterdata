package id.co.asyst.wfm.master.controller.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Employee;
import id.co.asyst.wfm.master.model.employee.EmployeeGroup;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.employee.EmployeeGroupService;
import id.co.asyst.wfm.master.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/master/employee")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeGroupService employeeGroupService;

    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeService.findAll();
    }

    @GetMapping(value = "/list", params = {"employeeId","publishName"})
    public Page<Employee> searchAllEmployee(@RequestParam("employeeId") String employeeId,
                                            @RequestParam("publishName") String publishName, Pageable pageable) {
        return employeeService.findByPublishedNameContains(employeeId, publishName.toUpperCase(), ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"employeeId","publishName"})
    public Page<Employee> searchAllEmployeeDelete(@RequestParam("employeeId") String employeeId,
                                            @RequestParam("publishName") String publishName, Pageable pageable) {
        return employeeService.findByPublishedNameContains(employeeId, publishName.toUpperCase(), ActiveEnum.N, pageable);
    }

    @PostMapping("/create/{employeeGroupCode}")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, @PathVariable(value = "employeeGroupCode") String employeeGroupCode) {

        Integer employeeCheck = employeeService.countByEmployeeId(employee.getEmployeeId());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if (employeeCheck > 0){
            responseProfile = new ResponseProfile("40009","Employee ID Already Exist","Create Employee");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            EmployeeGroup employeeGroup = (EmployeeGroup) employeeGroupService.findById(employeeGroupCode);
            employee.setEmployeeId(employee.getEmployeeId().toUpperCase());
            employee.setFirstName(employee.getFirstName().toUpperCase());
            employee.setLastName(employee.getLastName().toUpperCase());
            employee.setPublishedName(employee.getPublishedName().toUpperCase());
            employee.setEmployeeGroups(employeeGroup);
            employeeService.saveOrUpdate(employee);

            responseProfile = new ResponseProfile("00000","Success","Create Employee");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{employeeId}")
    public Employee getEmployeeById(@PathVariable(value = "employeeId") String employeeId) {
        return (Employee) employeeService.findById(employeeId);
    }

    @PutMapping("/update/{employeeId}/{employeeGroupCode}")
    public ResponseEntity<?> updateEmployee(@PathVariable(value = "employeeId") String employeeId,
                                   @PathVariable(value = "employeeGroupCode") String employeeGroupCode,
                                   @Valid @RequestBody Employee employeeDetails) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        Employee employee = (Employee) employeeService.findById(employeeId);
        EmployeeGroup employeeGroup = (EmployeeGroup) employeeGroupService.findById(employeeGroupCode);

        employee.setEmployeeGroups(employeeGroup);
        employee.setFirstName(employeeDetails.getFirstName().toUpperCase());
        employee.setLastName(employeeDetails.getLastName().toUpperCase());
        employee.setPublishedName(employeeDetails.getPublishedName().toUpperCase());
        employee.setBirthDate(employeeDetails.getBirthDate());
        employee.setBirthPlace(employeeDetails.getBirthPlace());
        employee.setGender(employeeDetails.getGender());
        employee.setAddress(employeeDetails.getAddress());
        employee.setPostalCode(employeeDetails.getPostalCode());
        employee.setCity(employeeDetails.getCity());
        employee.setProvince(employeeDetails.getProvince());
        employee.setNationality(employeeDetails.getNationality());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setMobilePhone(employeeDetails.getMobilePhone());
        employee.setJoinDate(employeeDetails.getJoinDate());
        employee.setResignationDate(employeeDetails.getResignationDate());
        employee.setEnableResignation(employeeDetails.getEnableResignation());
        employee.setLastEducation(employeeDetails.getLastEducation());
        employee.setHasAccount(employeeDetails.getHasAccount());
        employee.setActive(employeeDetails.getActive());
        employeeService.saveOrUpdate(employee);

        responseProfile = new ResponseProfile("00000","Success","Update Employee");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") String employeeId) {

        Employee employee = (Employee) employeeService.findById(employeeId);
        employee.setActive(ActiveEnum.N);
        employeeService.saveOrUpdate(employee);
        //employeeService.deleteById(employeeId);
        return ResponseEntity.ok().build();
    }

}
