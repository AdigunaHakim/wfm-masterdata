package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FunctionService<T,ID>  extends ServiceManager<T,ID>{
    Page<Function> findByFunctionCode(String functionCode, ActiveEnum active, Pageable pageable);
    List<Function> findByFunctionCode(String functionCode, ActiveEnum active);
    Integer countByFunctionCode(String functionCode);
}
