package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftTypeGroup;
import id.co.asyst.wfm.master.repository.flight.AircraftTypeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AircraftTypeGroupServiceImpl extends BaseServiceManager<AircraftTypeGroup, String> implements AircraftTypeGroupService<AircraftTypeGroup, String > {

    @Autowired
    AircraftTypeGroupRepository aircraftTypeGroupRepository;

    @Override
    public Collection<AircraftTypeGroup> findAll() {
        return (Collection<AircraftTypeGroup>) aircraftTypeGroupRepository.findAll();
    }

    @Override
    public AircraftTypeGroup findById(String code) {
        return aircraftTypeGroupRepository.findById(code).get();
    }

    @Override
    public AircraftTypeGroup saveOrUpdate(AircraftTypeGroup aircraftTypeGroup) {
        return aircraftTypeGroupRepository.save(aircraftTypeGroup);
    }

    @Override
    public void deleteById(String s) {
        aircraftTypeGroupRepository.deleteById(s);
    }

    @Override
    public void delete(AircraftTypeGroup aircraftTypeGroup) {
        aircraftTypeGroupRepository.delete(aircraftTypeGroup);
    }

    @Override
    public List<AircraftTypeGroup> findByAcTypeCodeList(String acTypeCode, ActiveEnum active) {
        return aircraftTypeGroupRepository.findByAcTypeGroupCodeContainsAndActive(acTypeCode, active);
    }

    @Override
    public Page<AircraftTypeGroup> findByActTypeCodePage(String acTypeCode, ActiveEnum active, Pageable pageable) {
        return aircraftTypeGroupRepository.findByAcTypeGroupCodeContainsAndActive(acTypeCode, active,  pageable);
    }

    @Override
    public Integer countByAcTypeGroupCode(String acTypeCode) {
        return aircraftTypeGroupRepository.countByAcTypeGroupCode(acTypeCode);
    }
}
