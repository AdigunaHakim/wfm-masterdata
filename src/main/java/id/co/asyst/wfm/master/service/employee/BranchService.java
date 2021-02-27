package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BranchService<T, ID> extends ServiceManager<T,ID> {
    Page<Branch> findByBranchCodeContains(String branchCode, ActiveEnum active, Pageable pageable);
}
