package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends BaseJpaRepository<Employee, String> {
    Page<Employee> findByEmployeeIdContainsAndPublishedNameContainsAndActive(String id, String name, ActiveEnum active,Pageable pageable);
    Employee findByUsername(String username);
    Integer countByEmployeeId(String id);
}
