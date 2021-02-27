package id.co.asyst.wfm.master.repository.employee;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BranchRepository extends BaseJpaRepository<Branch, String> {
    Page<Branch> findByBranchCodeContainsAndActive(String branchCode, ActiveEnum active, Pageable pageable);
}
