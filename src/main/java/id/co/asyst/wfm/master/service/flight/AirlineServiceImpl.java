package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.repository.flight.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AirlineServiceImpl extends BaseServiceManager<Airline, String> implements AirlineService<Airline, String> {

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public Collection<Airline> findAll() {
        return (Collection<Airline>) airlineRepository.findAll();
    }

    @Override
    public Airline findById(String s) {
        return airlineRepository.findById(s).get();
    }

    @Override
    public Airline saveOrUpdate(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public void deleteById(String s) {
        airlineRepository.deleteById(s);
    }

    @Override
    public void delete(Airline airline) {
        airlineRepository.delete(airline);
    }

    @Override
    public List<Airline> findByAirlineCodeList(String airlineCode, ActiveEnum active) {
        return airlineRepository.findByAirlineCodeContainsAndActive(airlineCode, active);
    }

    @Override
    public Page<Airline> findByAirlineCodePage(String airlineCode, ActiveEnum active, Pageable pageable) {
        return airlineRepository.findByAirlineCodeContainsAndActive(airlineCode, active, pageable);
    }

    @Override
    public Integer countById(String id) {
        return airlineRepository.countByAirlineCode(id);
    }
}
