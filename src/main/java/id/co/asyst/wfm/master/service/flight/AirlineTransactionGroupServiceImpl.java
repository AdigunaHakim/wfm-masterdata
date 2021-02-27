package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import id.co.asyst.wfm.master.model.flight.AirlineTransactionGroup;
import id.co.asyst.wfm.master.repository.flight.AirlineGroupRepository;
import id.co.asyst.wfm.master.repository.flight.AirlineRepository;
import id.co.asyst.wfm.master.repository.flight.AirlineTransactionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AirlineTransactionGroupServiceImpl extends BaseServiceManager<AirlineTransactionGroup, Long> implements AirlineTransactionGroupService<AirlineTransactionGroup, Long>{

    @Autowired
    AirlineTransactionGroupRepository airlineTransactionGroupRepository;

    @Autowired
    AirlineGroupRepository airlineGroupRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public List<Object[]> findByAirline(String airlineCode) {
        return airlineTransactionGroupRepository.findByAirlineCode(airlineCode);
    }

    @Override
    public List<Object[]> findByAirlineGroup(String airlineGroupCode) {
        return airlineTransactionGroupRepository.findByAirlineGroupCode(airlineGroupCode);
    }

    @Override
    public void deleteByAirline(String airlineCode) {
        airlineTransactionGroupRepository.deleteByairlineCode(airlineCode);
    }

    @Override
    public void deletebyAirlineGroup(String airlineGroupCode) {
        airlineTransactionGroupRepository.deleteByairlineGroupCode(airlineGroupCode);
    }

    @Override
    public List<Airline> findBySelectedAirline(String airlineGroupCode, String airlineCode) {
        return airlineRepository.findBySelectedAirline(airlineGroupCode, airlineCode);
    }

    @Override
    public List<AirlineGroup> findBySelectedAirlineGroup(String airlineCode, String airlineGroupCode) {
        return airlineGroupRepository.findBySelectedAirlineGroup(airlineCode, airlineGroupCode);
    }

    @Override
    public Collection<AirlineTransactionGroup> findAll() {
        return airlineTransactionGroupRepository.findAll();
    }

    @Override
    public AirlineTransactionGroup findById(Long aLong) {
        return airlineTransactionGroupRepository.findById(aLong).get();
    }

    @Override
    public AirlineTransactionGroup saveOrUpdate(AirlineTransactionGroup airlineTransactionGroup) {
        return airlineTransactionGroupRepository.save(airlineTransactionGroup);
    }

    @Override
    public void deleteById(Long aLong) {
        airlineTransactionGroupRepository.deleteById(aLong);
    }

    @Override
    public void delete(AirlineTransactionGroup airlineTransactionGroup) {

    }
}
