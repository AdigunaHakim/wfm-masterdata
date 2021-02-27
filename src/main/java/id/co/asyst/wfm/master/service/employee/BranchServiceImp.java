package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Branch;
import id.co.asyst.wfm.master.repository.employee.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BranchServiceImp extends BaseServiceManager<Branch, String > implements BranchService<Branch, String> {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Collection<Branch> findAll() {
        return (Collection<Branch>) branchRepository.findAll();
    }

    @Override
    public Branch findById(String code) {
        return branchRepository.findById(code).get();
    }

    @Override
    public Branch saveOrUpdate(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public void deleteById(String code) {
        branchRepository.deleteById(code);
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }

    @Override
    public Page<Branch> findByBranchCodeContains(String branchCode, ActiveEnum active, Pageable pageable) {
        return branchRepository.findByBranchCodeContainsAndActive(branchCode, active, pageable);
    }
}
