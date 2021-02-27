package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.EmployeeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeGroupService<T, ID> extends ServiceManager<T, ID> {
    Page<EmployeeGroup> findByEmployeeGroupCodeContains(String employeeGroupCode, ActiveEnum active, Pageable pageable);
    Integer findByEmployeeGroupCode(String employeeGroupCode);
}
