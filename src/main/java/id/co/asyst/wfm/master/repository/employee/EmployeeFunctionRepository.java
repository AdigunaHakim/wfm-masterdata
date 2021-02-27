package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.employee.EmployeeFunction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeFunctionRepository extends BaseJpaRepository<EmployeeFunction, Long> {

    @Query(value = "SELECT q.id, q.employee_id, q.function_code, q.valid_from, q.valid_to FROM employee_function q LEFT JOIN function x ON q.function_code=x.function_code " +
            "LEFT JOIN employee y ON q.employee_id=y.employee_id WHERE q.employee_id LIKE %?1% ORDER BY function_code ASC" , nativeQuery = true)
    List<Object[]> findByEmployeeId(String EmployeeId);

    @Query(value = "SELECT q.employee_id, q.function_code  FROM employee_function q LEFT JOIN function x ON q.function_code=x.function_code " +
            "LEFT JOIN employee y ON q.employee_id=y.employee_id WHERE q.function_code LIKE %?1%" , nativeQuery = true)
    List<EmployeeFunction> findByFunctionCode(String functionCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employee_function WHERE employee_id = ?1", nativeQuery = true)
    void deleteByEmployee(String employeeId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employee_function WHERE employee_id = ?1 and function_code = ?2", nativeQuery = true)
    void deleteByEmployeeAndFunction(String employeeId, String functionCode);
}
