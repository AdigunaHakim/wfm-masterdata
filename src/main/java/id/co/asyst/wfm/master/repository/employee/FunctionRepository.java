package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FunctionRepository extends BaseJpaRepository<Function, String> {
    Page<Function> findByFunctionCodeContainsAndActive(String functionCode, ActiveEnum active, Pageable pageable);
    List<Function> findByFunctionCodeContainsAndActive(String functionCode, ActiveEnum active);
    Integer countByFunctionCode(String functionCode);
}
