package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Qualification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QualificationRepository extends BaseJpaRepository<Qualification, String> {
    Page<Qualification> findByQualificationCodeContainsAndActive(String qualificationCode, ActiveEnum active, Pageable pageable);
    List<Qualification> findByQualificationCodeContainsAndActive(String qualificationCode, ActiveEnum active);
    Integer countByQualificationCode(String qualificationCode);

    @Query(value = "SELECT q.qualification_code, q.qualification_desc FROM qualification q WHERE q.qualification_code LIKE %?1%", nativeQuery = true)
    List<Object[]> findByQualificationCodeIs(String qualificationCode);
}
