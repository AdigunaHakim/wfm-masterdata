package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.FunctionQualification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FunctionQualificationService<T, ID> extends ServiceManager<T, ID> {
    List<Object[]> findByFunctionCode(String functionCode, ActiveEnum active);
    List<Object[]> findByQualificationCode(String qualificationCode, ActiveEnum active);
    Integer countByFunctionAndQualification(String functionCode, String qualificationCode);
    void deleteByFunction(String functionCode);
    void deleteByQualification(String qualificationCode);
}
