package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirlineTransactionGroupService<T, ID> extends ServiceManager<T,ID> {

    List<Object[]> findByAirline(String airlineCode);
    List<Object[]> findByAirlineGroup(String airlineGroupCode);
    void deleteByAirline(String airlineCode);
    void deletebyAirlineGroup(String airlineGroupCode);
    List<Airline> findBySelectedAirline(String airlineGroupCode, String airlineCode);
    List<AirlineGroup> findBySelectedAirlineGroup(String airlineCode, String airlineGroupCode);
}
