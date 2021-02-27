package id.co.asyst.wfm.master.repository.schedule;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.schedule.ShiftType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftTypeRepository extends BaseJpaRepository<ShiftType, String> {
    Page<ShiftType> findByShiftTypeCodeContainsAndActive(String shiftTypeCode, ActiveEnum active, Pageable pageable);
    Integer countByShiftTypeCode(String shiftTypeCode);
    Integer countByPublishName(String publishName);
}
