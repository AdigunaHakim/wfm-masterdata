package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.FunctionQualification;
import id.co.asyst.wfm.master.repository.employee.FunctionQualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FunctionQualificationServiceImpl extends BaseServiceManager<FunctionQualification, Long> implements FunctionQualificationService<FunctionQualification, Long> {

    @Autowired
    FunctionQualificationRepository functionQualificationRepository;

    @Override
    public Collection<FunctionQualification> findAll() {
        return (Collection<FunctionQualification>) functionQualificationRepository.findAll();
    }

    @Override
    public FunctionQualification findById(Long aLong) {
        return functionQualificationRepository.findById(aLong).get();
    }

    @Override
    public FunctionQualification saveOrUpdate(FunctionQualification functionQualification) {
        return functionQualificationRepository.save(functionQualification);
    }

    @Override
    public void deleteById(Long aLong) {
        functionQualificationRepository.deleteById(aLong);
    }

    @Override
    public void delete(FunctionQualification functionQualification) {
        functionQualificationRepository.delete(functionQualification);
    }

    @Override
    public List<Object[]> findByFunctionCode(String functionCode, ActiveEnum active) {
        return functionQualificationRepository.findByFunctionCode(functionCode, active);
    }

    @Override
    public List<Object[]> findByQualificationCode(String qualificationCode, ActiveEnum active) {
        return functionQualificationRepository.findByQualification(qualificationCode, active);
    }

    @Override
    public Integer countByFunctionAndQualification(String functionCode, String qualificationCode) {
        return functionQualificationRepository.countByFunctionAndQualification(functionCode, qualificationCode);
    }

    @Override
    public void deleteByFunction(String functionCode) {
        functionQualificationRepository.deleteByFunction(functionCode);
    }

    @Override
    public void deleteByQualification(String qualificationCode) {
        functionQualificationRepository.deleteByQualification(qualificationCode);
    }
}
