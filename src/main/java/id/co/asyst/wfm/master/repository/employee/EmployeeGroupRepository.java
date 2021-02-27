package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.EmployeeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeGroupRepository extends BaseJpaRepository<EmployeeGroup, String> {
    Page<EmployeeGroup> findByEmployeeGroupCodeContainsAndActive(String employeeGroupCode, ActiveEnum active, Pageable pageable);
    Integer countByEmployeeGroupCode(String employeeGroupCode);
}
