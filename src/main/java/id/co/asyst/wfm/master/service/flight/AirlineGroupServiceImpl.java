package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import id.co.asyst.wfm.master.repository.flight.AirlineGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AirlineGroupServiceImpl extends BaseServiceManager<AirlineGroup, String> implements AirlineGroupService<AirlineGroup, String>{

    @Autowired
    AirlineGroupRepository airlineGroupRepository;

    @Override
    public Collection<AirlineGroup> findAll() {
        return (Collection<AirlineGroup>) airlineGroupRepository.findAll();
    }

    @Override
    public AirlineGroup findById(String s) {
        return airlineGroupRepository.findById(s).get();
    }

    @Override
    public AirlineGroup saveOrUpdate(AirlineGroup airlineGroup) {
        return airlineGroupRepository.save(airlineGroup);
    }

    @Override
    public void deleteById(String s) {
        airlineGroupRepository.deleteById(s);
    }

    @Override
    public void delete(AirlineGroup airlineGroup) {
        airlineGroupRepository.delete(airlineGroup);
    }

    @Override
    public List<AirlineGroup> findByAirlineGroupCodeList(String airlineGroupCode, ActiveEnum active) {
        return airlineGroupRepository.findByAirlineGroupCodeContainsAndActive(airlineGroupCode, active);
    }

    @Override
    public Page<AirlineGroup> findByAirlineGroupCodePage(String airlineGroupCode, ActiveEnum active, Pageable pageable) {
        return airlineGroupRepository.findByAirlineGroupCodeContainsAndActive(airlineGroupCode, active, pageable);
    }

    @Override
    public Integer countByAirlineGroupCode(String airlineGroupCode) {
        return airlineGroupRepository.countByAirlineGroupCode(airlineGroupCode);
    }
}
