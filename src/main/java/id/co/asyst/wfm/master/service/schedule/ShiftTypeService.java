package id.co.asyst.wfm.master.service.schedule;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.schedule.ShiftType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShiftTypeService<T, ID> extends ServiceManager<T, ID> {
    Page<ShiftType> findByBranchCodeContains(String shiftTypeCode, ActiveEnum active, Pageable pageable);
    Integer countByShfitTypeCode(String shiftTypeCode);
    Integer countByPublishName(String publishName);
}
