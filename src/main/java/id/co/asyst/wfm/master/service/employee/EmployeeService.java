package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService<T,ID> extends ServiceManager<T, ID> {
    Page<Employee> findByPublishedNameContains(String employeeId, String publishName, ActiveEnum active, Pageable pageable);
    Integer countByEmployeeId(String employeeId);
}
