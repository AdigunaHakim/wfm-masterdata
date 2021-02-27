package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Qualification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QualificationService<T,ID> extends ServiceManager<T,ID> {
    Page<Qualification> findByQualificationCode(String qualificationCode, ActiveEnum active, Pageable pageable);
    List<Qualification> findByQualifiationCodeIs(String qualificationCode, ActiveEnum active);
    Integer countByQualificationCode(String qualificationCode);
}
