package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineGroupService<T, ID> extends ServiceManager<T, ID> {
    List<AirlineGroup> findByAirlineGroupCodeList(String airlineGroupCode, ActiveEnum active);
    Page<AirlineGroup> findByAirlineGroupCodePage(String airlineGroupCode, ActiveEnum active, Pageable pageable);
    Integer countByAirlineGroupCode(String airlineGroupCode);
}
