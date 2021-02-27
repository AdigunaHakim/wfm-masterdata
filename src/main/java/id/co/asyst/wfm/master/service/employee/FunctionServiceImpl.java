package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Function;
import id.co.asyst.wfm.master.repository.employee.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FunctionServiceImpl extends BaseServiceManager<Function, String> implements FunctionService<Function, String>{

    @Autowired
    FunctionRepository functionRepository;

    @Override
    public Collection<Function> findAll() {
        return (Collection<Function>) functionRepository.findAll();
    }

    @Override
    public Function findById(String code) {
        return functionRepository.findById(code).get();
    }

    @Override
    public Function saveOrUpdate(Function function) {
        return functionRepository.save(function);
    }

    @Override
    public void deleteById(String code) {
        functionRepository.deleteById(code);
    }

    @Override
    public void delete(Function function) {
        functionRepository.delete(function);
    }

    @Override
    public Page<Function> findByFunctionCode(String functionCode, ActiveEnum active, Pageable pageable) {
        return functionRepository.findByFunctionCodeContainsAndActive(functionCode, active, pageable);
    }

    @Override
    public List<Function> findByFunctionCode(String functionCode, ActiveEnum active) {
        return functionRepository.findByFunctionCodeContainsAndActive(functionCode, active);
    }

    @Override
    public Integer countByFunctionCode(String functionCode) {
        return functionRepository.countByFunctionCode(functionCode);
    }
}
