package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Employee;
import id.co.asyst.wfm.master.model.employee.EmployeeGroup;
import id.co.asyst.wfm.master.repository.employee.EmployeeGroupRepository;
import id.co.asyst.wfm.master.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeGroupServiceImpl extends BaseServiceManager<EmployeeGroup, String> implements EmployeeGroupService<EmployeeGroup, String> {

    @Autowired
    private EmployeeGroupRepository employeeGroupRepository;

    @Override
    public Collection<EmployeeGroup> findAll() {
        return (Collection<EmployeeGroup>) employeeGroupRepository.findAll();
    }

    @Override
    public EmployeeGroup findById(String code) {
        return employeeGroupRepository.findById(code).get();
    }

    @Override
    public EmployeeGroup saveOrUpdate(EmployeeGroup employeeGroup) {
        return employeeGroupRepository.save(employeeGroup);
    }

    @Override
    public void deleteById(String code) {
        employeeGroupRepository.deleteById(code);
    }

    @Override
    public void delete(EmployeeGroup employeeGroup) {
        employeeGroupRepository.delete(employeeGroup);
    }

    @Override
    public Page<EmployeeGroup> findByEmployeeGroupCodeContains(String employeeGroupCode, ActiveEnum active, Pageable pageable) {
        return employeeGroupRepository.findByEmployeeGroupCodeContainsAndActive(employeeGroupCode, active, pageable);
    }

    @Override
    public Integer findByEmployeeGroupCode(String employeeGroupCode) {
        return employeeGroupRepository.countByEmployeeGroupCode(employeeGroupCode);
    }
}
