package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AircraftTypeService<T, ID> extends ServiceManager<T,ID>{

    List<AircraftType> findByAircraftTypeCodeList(String aircraftTypeCode, ActiveEnum active);
    Page<AircraftType> findByAircraftTypeCodePage(String aircraftTypeCode, ActiveEnum active, Pageable pageable);
    List<AircraftType> findBySelectAircraft(String acTypeGroupCode, String acTypeCode);
    Integer countById(String id);
}
