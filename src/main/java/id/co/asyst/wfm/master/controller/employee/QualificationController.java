package id.co.asyst.wfm.master.controller.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Function;
import id.co.asyst.wfm.master.model.employee.FunctionQualification;
import id.co.asyst.wfm.master.model.employee.Qualification;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.employee.FunctionQualificationService;
import id.co.asyst.wfm.master.service.employee.FunctionService;
import id.co.asyst.wfm.master.service.employee.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/master/qualification")
public class QualificationController {

    @Autowired
    QualificationService qualificationService;

    @Autowired
    FunctionQualificationService functionQualificationService;

    @GetMapping("/list")
    public List<Qualification> getAll() {
        return (List<Qualification>) qualificationService.findAll();
    }

    @GetMapping(value = "/list/suggest",  params = {"qualificationCode"})
    public List<Qualification> getSuggest(@RequestParam("qualificationCode") String qualificationCode) {
        return qualificationService.findByQualifiationCodeIs(qualificationCode, ActiveEnum.Y);

        //return objects.stream().map(o-> new Qualification((String)o[0],(String)o[1])).collect(Collectors.toList());
    }

    @GetMapping(value = "/list", params = {"qualificationCode"})
    public Page<Qualification> getAll(@RequestParam("qualificationCode") String qualificationCode, Pageable pageable) {
        return qualificationService.findByQualificationCode(qualificationCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"qualificationCode"})
    public Page<Qualification> getAllDelete(@RequestParam("qualificationCode") String qualificationCode, Pageable pageable) {
        return qualificationService.findByQualificationCode(qualificationCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Qualification qualification) {

        Integer qualificationCheck = qualificationService.countByQualificationCode(qualification.getQualificationCode().toUpperCase());
        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        if(qualificationCheck > 0){
            responseProfile = new ResponseProfile("40009","Qualification Code Already Exist","Create Qualification");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.BAD_REQUEST);
        }
        else{
            qualification.setQualificationCode(qualification.getQualificationCode().toUpperCase());
            qualificationService.saveOrUpdate(qualification);

            responseProfile = new ResponseProfile("00000","Success","Create Qualification");
            responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/find/{id}")
    public Qualification getById(@PathVariable(value = "id") String qualificationId) {
        return (Qualification) qualificationService.findById(qualificationId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") String qualificationId,
                           @Valid @RequestBody Qualification qualificationDetails) {

        ResponseProfile responseProfile = null;
        ResponseEntity responseEntity = null;

        Qualification qualification = (Qualification) qualificationService.findById(qualificationId);
        qualification.setQualificationDesc(qualificationDetails.getQualificationDesc());
        qualification.setActive(qualificationDetails.getActive());
        qualificationService.saveOrUpdate(qualification);

        responseProfile = new ResponseProfile("00000","Success","Update Qualification");
        responseEntity = new ResponseEntity<>(responseProfile, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String  functionId) {

        Qualification qualification = (Qualification) qualificationService.findById(functionId);
        /*List<FunctionQualification> functionQualification = functionQualificationService.findByQualificationCode(functionId, ActiveEnum.Y);
        for(int i=0; i<functionQualification.size(); i++){
            functionQualification.get(i).setActive(ActiveEnum.N);
            functionQualificationService.saveOrUpdate(functionQualification.get(i));
        }
        //qualificationService.deleteById(functionId);*/
        qualification.setActive(ActiveEnum.N);
        qualificationService.saveOrUpdate(qualification);
        return ResponseEntity.ok().build();
    }
}
