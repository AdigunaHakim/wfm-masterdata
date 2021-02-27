package id.co.asyst.wfm.master.controller.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.*;
import id.co.asyst.wfm.master.payload.employee.EmployeeFunctionInsert;
import id.co.asyst.wfm.master.payload.employee.EmployeeFunctionProfile;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.employee.EmployeeFunctionService;
import id.co.asyst.wfm.master.service.employee.EmployeeService;
import id.co.asyst.wfm.master.service.employee.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/master/employee-function")
public class EmployeeFunctionController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    FunctionService functionService;

    @Autowired
    EmployeeFunctionService employeeFunctionService;

    @GetMapping("/list")
    public List<EmployeeFunction> getAll() {
        return (List<EmployeeFunction>) employeeFunctionService.findAll();
    }

    @GetMapping(value = "/list", params = {"employeeId"})
    public List<EmployeeFunctionProfile> getAll(@RequestParam("employeeId") String employeeId) {
        List<Object[]> objects = employeeFunctionService.findByEmployeeId(employeeId);

        return objects.stream().map(o-> new EmployeeFunctionProfile((BigInteger)o[0],(String)o[1],(String)o[2],(Date)o[3],(Date)o[4])).collect(Collectors.toList());
    }

    @PostMapping("/set")
    public ResponseEntity<?> create(@Valid @RequestBody EmployeeFunctionInsert employeeFunctionDetail) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;
        String[] function = employeeFunctionDetail.getFunctionCode();
        LocalDate[] validFrom = employeeFunctionDetail.getValidFrom();
        LocalDate[] validTo = employeeFunctionDetail.getValidTo();
        Integer[] enableValidFrom = employeeFunctionDetail.getEnableValidFrom();
        Integer[] enableValidTo = employeeFunctionDetail.getEnableValidTo();

        /*Integer countCheck = employeeService.countByEmployeeId(employeeFunctionDetail.getEmployeeId().toUpperCase());
        if(countCheck == 0){
        }*/

        employeeFunctionService.deleteByEmployee(employeeFunctionDetail.getEmployeeId().toUpperCase());
        Employee employeeCheck = (Employee) employeeService.findById(employeeFunctionDetail.getEmployeeId().toUpperCase());

        int i = 0;
        while(i < function.length){

            EmployeeFunction employeeFunction = new EmployeeFunction();
            Function functionList = (Function) functionService.findById(function[i].toUpperCase());
            Employee employee = (Employee) employeeService.findById(employeeFunctionDetail.getEmployeeId().toUpperCase());
            employeeFunction.setEmployee(employee);
            employeeFunction.setFunction(functionList);
            employeeFunction.setEnableValidFrom(enableValidFrom[i]);
            employeeFunction.setValidFrom(validFrom[i]);
            employeeFunction.setEnableValidTo(enableValidTo[i]);
            employeeFunction.setValidTo(validTo[i]);
            employeeFunction.setActive(employeeFunctionDetail.getActive());

            employeeFunctionService.saveOrUpdate(employeeFunction);
            //}
            i ++;
        }

        responseProfile = new ResponseProfile("00000","Success","Set Employee Function");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public EmployeeFunction getById(@PathVariable(value = "id") String Id) {
        return (EmployeeFunction) employeeFunctionService.findById(Id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable(value = "employeeId") Integer  id) {

        //EmployeeFunction employeeFunction = (EmployeeFunction) employeeFunctionService.findById(id);
        //employeeFunction.setActive(ActiveEnum.N);
        //employeeFunctionService.saveOrUpdate(employeeFunction);
        employeeFunctionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
