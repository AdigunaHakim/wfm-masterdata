package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.employee.EmployeeFunction;

import java.util.List;

public interface EmployeeFunctionService<T, ID> extends ServiceManager<T, ID> {

    List<Object[]> findByEmployeeId(String employeeId);
    List<EmployeeFunction> findByFunction(String functionCode);
    List<EmployeeFunction> saveAll(List<EmployeeFunction> employeeFunctions);
    void deleteByEmployee(String employeeId);
    void deleteByEmployeeAndFunction(String employeeId, String functionCode);
}
