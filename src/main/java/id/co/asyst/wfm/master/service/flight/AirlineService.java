package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineService<T, ID> extends ServiceManager<T,ID> {

    List<Airline> findByAirlineCodeList(String airlineCode, ActiveEnum active);
    Page<Airline> findByAirlineCodePage(String airlineCode, ActiveEnum active, Pageable pageable);
    Integer countById(String id);
}
