package id.co.asyst.wfm.master.controller.employee;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Branch;
import id.co.asyst.wfm.master.service.employee.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/master/branch")
public class BranchController {
    @Autowired
    BranchService branchRepository;

    @GetMapping("/list")
    public List<Branch> getAllBranch() {
        return (List<Branch>) branchRepository.findAll();
    }

    @GetMapping(value = "/list", params = {"branchCode"})
    public Page<Branch> getAllBranch(@RequestParam("branchCode") String branchCode, Pageable pageable) {
        return branchRepository.findByBranchCodeContains(branchCode, ActiveEnum.Y, pageable);
    }

    @GetMapping(value = "/list-delete", params = {"branchCode"})
    public Page<Branch> getAllBranchDelete(@RequestParam("branchCode") String branchCode, Pageable pageable) {
        return branchRepository.findByBranchCodeContains(branchCode, ActiveEnum.N, pageable);
    }

    @PostMapping("/create")
    public Branch createBranch(@Valid @RequestBody Branch branch) {
        branch.setBranchCode(branch.getBranchCode().toUpperCase());
        return (Branch) branchRepository.saveOrUpdate(branch);
    }

    @GetMapping("/find/{id}")
    public Branch getBranchById(@PathVariable(value = "id") String branchId) {
        return (Branch) branchRepository.findById(branchId);
    }

    @PutMapping("/update/{id}")
    public Branch updateBranch(@PathVariable(value = "id") String branchId,
                               @Valid @RequestBody Branch branchDetails) {

        Branch branch = (Branch) branchRepository.findById(branchId.toUpperCase());

        branch.setBranchDesc(branchDetails.getBranchDesc());
        branch.setActive(branchDetails.getActive());

       return (Branch) branchRepository.saveOrUpdate(branch);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable(value = "id") String  branchId) {

        Branch branch = (Branch) branchRepository.findById(branchId);
        branch.setActive(ActiveEnum.N);
        branchRepository.saveOrUpdate(branch);
        //branchRepository.deleteById(branchId);
        return ResponseEntity.ok().build();
    }
}
