package id.co.asyst.wfm.master.controller.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.*;
import id.co.asyst.wfm.master.payload.employee.FunctionQualificationInsert;
import id.co.asyst.wfm.master.payload.employee.FunctionQualificationProfile;
import id.co.asyst.wfm.master.payload.employee.QualificationFunctionInsert;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/master/function-qual")
public class FunctionQualificationController {

    @Autowired
    FunctionQualificationService functionQualificationService;

    @Autowired
    FunctionService functionService;

    @Autowired
    QualificationService qualificationService;

    @GetMapping("/list")
    public List<FunctionQualification> getAll() {
        return (List<FunctionQualification>) functionQualificationService.findAll();
    }

    @PostMapping("/create/{functionCode}/{qualificationCode}")
    public FunctionQualification create(@PathVariable (value = "functionCode") String functionCode,
                                        @PathVariable (value = "qualificationCode") String qualificationCode,
                                             @Valid @RequestBody FunctionQualification functionQualification) {

        Function function = (Function) functionService.findById(functionCode.toUpperCase());
        Qualification qualification = (Qualification) qualificationService.findById(qualificationCode.toUpperCase());
        functionQualification.setFunction(function);
        functionQualification.setQualification(qualification);

        return (FunctionQualification) functionQualificationService.saveOrUpdate(functionQualification);
    }

    @PostMapping("/set/function")
    public ResponseEntity<?> createByFunction(@Valid @RequestBody FunctionQualificationInsert functionQualificationDetail) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;
        String[] qual = functionQualificationDetail.getQualification();

        /*Integer countCheck = functionService.countByFunctionCode(functionQualificationDetail.getFunctionCode().toUpperCase());
        String[] qual = functionQualificationDetail.getQualification();

        if(countCheck == 0){
            Function functionCreate = new Function();
            functionCreate.setFunctionCode(functionQualificationDetail.getFunctionCode().toUpperCase());
            functionCreate.setFunctionDesc(functionQualificationDetail.getFunctionDesc());
            functionCreate.setActive(functionQualificationDetail.getActive());

            functionService.saveOrUpdate(functionCreate);
        }*/

        functionQualificationService.deleteByFunction(functionQualificationDetail.getFunctionCode().toUpperCase());
        Function functionCheck = (Function) functionService.findById(functionQualificationDetail.getFunctionCode().toUpperCase());

        int i = 0;
        while(i < qual.length){
            //Integer countCheck = functionQualificationService.countByFunctionAndQualification(functionQualificationDetail.getFunctionCode(), qual[i]);
            //if (countCheck < 1){

                FunctionQualification functionQualification = new FunctionQualification();
                Function function = (Function) functionService.findById(functionQualificationDetail.getFunctionCode().toUpperCase());
                Qualification qualification = (Qualification) qualificationService.findById(qual[i].toUpperCase());
                functionQualification.setFunction(function);
                functionQualification.setQualification(qualification);
                functionQualification.setActive(functionQualificationDetail.getActive());

                functionQualificationService.saveOrUpdate(functionQualification);
            //}
            i ++;
        }

        functionCheck.setFunctionDesc(functionQualificationDetail.getFunctionDesc());
        functionService.saveOrUpdate(functionCheck);
        responseProfile = new ResponseProfile("00000","Success","Set Function Qualification");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/set/qualification")
    public ResponseEntity<?> createByQualification(@Valid @RequestBody QualificationFunctionInsert qualificationFunctionDetail) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;
        String[] func = qualificationFunctionDetail.getFunction();
        /*Integer countCheck = qualificationService.countByQualificationCode(qualificationFunctionDetail.getQualificationCode().toUpperCase());
        String[] func = qualificationFunctionDetail.getFunction();

        if(countCheck == 0){
            Qualification qualificationCreate = new Qualification();
            qualificationCreate.setQualificationCode(qualificationFunctionDetail.getQualificationCode().toUpperCase());
            qualificationCreate.setQualificationDesc(qualificationFunctionDetail.getQualificationDesc());
            qualificationCreate.setActive(qualificationFunctionDetail.getActive());

            qualificationService.saveOrUpdate(qualificationCreate);
        }*/

        functionQualificationService.deleteByQualification(qualificationFunctionDetail.getQualificationCode().toUpperCase());
        Qualification qualificationCheck = (Qualification) qualificationService.findById(qualificationFunctionDetail.getQualificationCode().toUpperCase());

        int i = 0;
        while(i < func.length){
            //Integer countCheck = functionQualificationService.countByFunctionAndQualification(functionQualificationDetail.getFunctionCode(), qual[i]);
            //if (countCheck < 1){

            FunctionQualification functionQualification = new FunctionQualification();
            Function function = (Function) functionService.findById(func[i].toUpperCase());
            Qualification qualification = (Qualification) qualificationService.findById(qualificationFunctionDetail.getQualificationCode().toUpperCase());
            functionQualification.setFunction(function);
            functionQualification.setQualification(qualification);
            functionQualification.setActive(qualificationFunctionDetail.getActive());

            functionQualificationService.saveOrUpdate(functionQualification);
            //}
            i ++;
        }

        qualificationCheck.setQualificationDesc(qualificationFunctionDetail.getQualificationDesc());
        qualificationService.saveOrUpdate(qualificationCheck);

        responseProfile = new ResponseProfile("00000","Success","Set Function Qualification");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        return responseEntity;
    }


    @GetMapping("/find/{id}")
    public FunctionQualification getById(@PathVariable(value = "id") Long id) {
        return (FunctionQualification) functionQualificationService.findById(id);
    }

    @GetMapping(value = "/find/qualification", params = {"functionCode"})
    public List<FunctionQualificationProfile> getByFunction(@RequestParam("functionCode") String functionCode) {
        List<Object[]> objects = functionQualificationService.findByFunctionCode(functionCode, ActiveEnum.Y);

        return objects.stream().map(o-> new FunctionQualificationProfile((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/find/function", params = {"qualificationCode"})
    public List<FunctionQualificationProfile> getByQualification(@RequestParam("qualificationCode") String qualificationCode) {
        List<Object[]> objects = functionQualificationService.findByQualificationCode(qualificationCode, ActiveEnum.Y);

        return objects.stream().map(o-> new FunctionQualificationProfile((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public FunctionQualification update(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody FunctionQualification functionQualificationDetails) {

        FunctionQualification functionQualification = (FunctionQualification) functionQualificationService.findById(id);

        return (FunctionQualification) functionQualificationService.saveOrUpdate(functionQualification);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value = "id") Long id) {

        //FunctionQualification functionQualification = (FunctionQualification) functionQualificationService.findById(id);
        //functionQualification.setActive(ActiveEnum.N);
        //functionQualificationService.saveOrUpdate(functionQualification);
        functionQualificationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
