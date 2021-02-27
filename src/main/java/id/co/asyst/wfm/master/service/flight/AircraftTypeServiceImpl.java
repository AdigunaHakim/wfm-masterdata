package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import id.co.asyst.wfm.master.repository.flight.AircraftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AircraftTypeServiceImpl extends BaseServiceManager<AircraftType, String> implements AircraftTypeService<AircraftType, String>{

    @Autowired
    AircraftTypeRepository aircraftTypeRepository;

    @Override
    public Collection<AircraftType> findAll() {
        return (Collection<AircraftType>) aircraftTypeRepository.findAll();
    }

    @Override
    public AircraftType findById(String s) {
        return aircraftTypeRepository.findById(s).get();
    }

    @Override
    public AircraftType saveOrUpdate(AircraftType aircraftType) {
        return aircraftTypeRepository.save(aircraftType);
    }

    @Override
    public void deleteById(String s) {
        aircraftTypeRepository.deleteById(s);
    }

    @Override
    public void delete(AircraftType aircraftType) {
        aircraftTypeRepository.delete(aircraftType);
    }

    @Override
    public List<AircraftType> findByAircraftTypeCodeList(String aircraftTypeCode, ActiveEnum active) {
        return aircraftTypeRepository.findByAcTypeCodeContainsAndActive(aircraftTypeCode, active);
    }

    @Override
    public Page<AircraftType> findByAircraftTypeCodePage(String aircraftTypeCode, ActiveEnum active, Pageable pageable) {
        return aircraftTypeRepository.findByAcTypeCodeContainsAndActive(aircraftTypeCode, active, pageable);
    }

    @Override
    public List<AircraftType> findBySelectAircraft(String acTypeGroupCode, String acTypeCode) {
        return aircraftTypeRepository.findBySelectAircraft(acTypeGroupCode, acTypeCode);
    }

    @Override
    public Integer countById(String id) {
        return aircraftTypeRepository.countByAcTypeCode(id);
    }
}
