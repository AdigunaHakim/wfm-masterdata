package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Employee;
import id.co.asyst.wfm.master.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl extends BaseServiceManager<Employee, String> implements EmployeeService<Employee, String> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Collection<Employee> findAll() {
        return (Collection<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee findById(String code) {
        return employeeRepository.findById(code).get();
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(String code) {
        employeeRepository.deleteById(code);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findByPublishedNameContains(String id, String name, ActiveEnum active, Pageable pageable) {
        return employeeRepository.findByEmployeeIdContainsAndPublishedNameContainsAndActive(id, name, active, pageable);
    }

    @Override
    public Integer countByEmployeeId(String employeeId) {
        return employeeRepository.countByEmployeeId(employeeId);
    }
}
