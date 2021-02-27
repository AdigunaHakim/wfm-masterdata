package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.FunctionQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface FunctionQualificationRepository extends BaseJpaRepository<FunctionQualification, Long> {

    @Query(value = "SELECT q.function_code, q.qualification_code FROM function_qualification q LEFT JOIN function x ON q.function_code=x.function_code " +
            "LEFT JOIN qualification y ON q.qualification_code=y.qualification_code WHERE q.function_code = ?1" , nativeQuery = true)
    List<Object[]> findByFunctionCode(String functionCode, ActiveEnum active);

    @Query(value = "SELECT q.function_code, q.qualification_code FROM function_qualification q LEFT JOIN function x ON q.function_code=x.function_code " +
            "LEFT JOIN qualification y ON q.qualification_code=y.qualification_code WHERE q.qualification_code = ?1", nativeQuery = true)
    List<Object[]> findByQualification(String qualificationCode, ActiveEnum active);

    @Query(value = "SELECT COUNT(*) FROM function_qualification WHERE function_code = ?1 AND qualification_code = ?2", nativeQuery = true)
    Integer countByFunctionAndQualification(String functionCode, String qualificationCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM function_qualification WHERE function_code = ?1", nativeQuery = true)
    void deleteByFunction(String functionCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM function_qualification WHERE qualification_code = ?1", nativeQuery = true)
    void deleteByQualification(String qualificationCode);
}
