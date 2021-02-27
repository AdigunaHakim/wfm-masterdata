package id.co.asyst.wfm.master.controller.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Function;
import id.co.asyst.wfm.master.model.employee.FunctionQualification;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.employee.FunctionQualificationService;
import id.co.asyst.wfm.master.service.employee.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/function")
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @Autowired
    FunctionQualificationService functionQualificationService;

    @GetMapping("/list")
    public List<Function> getAllBranch() {
        return (List<Function>) functionService.findAll();
    }

    @GetMapping(value = "/list/suggest", params = {"functionCode"})
    public List<Function> getAll(@RequestParam("functionCode") String functionCode) {
        return functionService.findByFunctionCode(functionCode, ActiveEnum.Y);
    }

    @GetMapping(value = "/list", params = {"functionCode"})
    public Page<Function> getAll(@RequestParam("functionCode") String functionCode, Pageable pageable) {
        return functionService.findByFunctionCode(functionCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"functionCode"})
    public Page<Function> getAllDelete(@RequestParam("functionCode") String functionCode, Pageable pageable) {
        return functionService.findByFunctionCode(functionCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Function function) {

        Integer functionCheck = functionService.countByFunctionCode(function.getFunctionCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if (functionCheck > 0){
            responseProfile = new ResponseProfile("40009","Function Code Already Exist","Create Function");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            String functionCode = function.getFunctionCode().toUpperCase();
            function.setFunctionCode(functionCode);
            functionService.saveOrUpdate(function);

            responseProfile = new ResponseProfile("00000","Success","Create Function");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public Function getById(@PathVariable(value = "id") String branchId) {
        return (Function) functionService.findById(branchId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") String functionId,
                               @Valid @RequestBody Function functionDetails) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        Function function = (Function) functionService.findById(functionId);
        function.setFunctionDesc(functionDetails.getFunctionDesc());
        function.setActive(functionDetails.getActive());
        functionService.saveOrUpdate(function);

        responseProfile = new ResponseProfile("00000","Success","Update Function");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  functionId) {

        Function function = (Function) functionService.findById(functionId);
        /*List<FunctionQualification> functionQualification = functionQualificationService.findByFunctionCode(functionId, ActiveEnum.Y);
        for(int i=0; i<functionQualification.size(); i++){
            functionQualification.get(i).setActive(ActiveEnum.N);
            functionQualificationService.saveOrUpdate(functionQualification.get(i));
        }
        //functionService.deleteById(functionId);*/
        function.setActive(ActiveEnum.N);
        functionService.saveOrUpdate(function);
        return ResponseEntity.ok().build();
    }
}