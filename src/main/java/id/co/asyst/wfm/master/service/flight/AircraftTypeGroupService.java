package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftTypeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AircraftTypeGroupService<T,ID> extends ServiceManager<T,ID>{

    List<AircraftTypeGroup> findByAcTypeCodeList(String acTypeCode, ActiveEnum active);
    Page<AircraftTypeGroup> findByActTypeCodePage(String acTypeCode, ActiveEnum active, Pageable pageable);
    Integer countByAcTypeGroupCode(String acTypeCode);
}
