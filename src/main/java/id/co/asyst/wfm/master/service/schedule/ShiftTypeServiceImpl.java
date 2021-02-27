package id.co.asyst.wfm.master.service.schedule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.schedule.ShiftType;
import id.co.asyst.wfm.master.repository.schedule.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShiftTypeServiceImpl extends BaseServiceManager<ShiftType, String> implements ShiftTypeService<ShiftType, String> {

    @Autowired
    private ShiftTypeRepository shiftTypeRepository;

    @Override
    public Collection<ShiftType> findAll() {
        return (Collection<ShiftType>) shiftTypeRepository.findAll();
    }

    @Override
    public ShiftType findById(String code) {
        return shiftTypeRepository.findById(code).get();
    }

    @Override
    public ShiftType saveOrUpdate(ShiftType shiftType) {
        return shiftTypeRepository.saveAndFlush(shiftType);
    }

    @Override
    public void deleteById(String code) {
        shiftTypeRepository.deleteById(code);
    }

    @Override
    public void delete(ShiftType shiftType) {
        shiftTypeRepository.delete(shiftType);
    }

    @Override
    public Page<ShiftType> findByBranchCodeContains(String shiftTypeCode, ActiveEnum active, Pageable pageable) {
        return shiftTypeRepository.findByShiftTypeCodeContainsAndActive(shiftTypeCode, active, pageable);
    }

    @Override
    public Integer countByShfitTypeCode(String shiftTypeCode) {
        return shiftTypeRepository.countByShiftTypeCode(shiftTypeCode);
    }

    @Override
    public Integer countByPublishName(String publishName) {
        return shiftTypeRepository.countByPublishName(publishName);
    }
}