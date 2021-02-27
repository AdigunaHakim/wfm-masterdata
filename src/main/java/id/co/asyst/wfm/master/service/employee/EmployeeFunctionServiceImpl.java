package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.employee.EmployeeFunction;
import id.co.asyst.wfm.master.repository.employee.EmployeeFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeFunctionServiceImpl extends BaseServiceManager<EmployeeFunction, Long> implements EmployeeFunctionService<EmployeeFunction,Long> {

    @Autowired
    EmployeeFunctionRepository employeeFunctionRepository;

    @Override
    public Collection<EmployeeFunction> findAll() {
        return (Collection<EmployeeFunction>) employeeFunctionRepository.findAll();
    }

    @Override
    public EmployeeFunction findById(Long aLong) {
        return employeeFunctionRepository.findById(aLong).get();
    }

    @Override
    public EmployeeFunction saveOrUpdate(EmployeeFunction employeeFunction) {
        return employeeFunctionRepository.save(employeeFunction);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeFunctionRepository.deleteById(aLong);
    }

    @Override
    public void delete(EmployeeFunction employeeFunction) {
        employeeFunctionRepository.delete(employeeFunction);
    }

    @Override
    public List<Object[]> findByEmployeeId(String employeeId) {
        return employeeFunctionRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeFunction> findByFunction(String functionCode) {
        return employeeFunctionRepository.findByFunctionCode(functionCode);
    }

    @Override
    public List<EmployeeFunction> saveAll(List<EmployeeFunction> employeeFunctions) {
        return employeeFunctionRepository.saveAll(employeeFunctions);
    }

    @Override
    public void deleteByEmployee(String employeeId) {
        employeeFunctionRepository.deleteByEmployee(employeeId);
    }

    @Override
    public void deleteByEmployeeAndFunction(String employeeId, String functionCode) {
        employeeFunctionRepository.deleteByEmployeeAndFunction(employeeId, functionCode);
    }
}
