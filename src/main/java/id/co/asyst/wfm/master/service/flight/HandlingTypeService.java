package id.co.asyst.wfm.master.service.flight;


import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.flight.HandlingType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HandlingTypeService<T, ID> extends ServiceManager<T, ID>{

    List<HandlingType> findByHandlingTypeCodeList(String handlingTypeCode);
    Page<HandlingType> findByHandlingTypeCodePage(String handlingTypeCode, Pageable pageable);
    Integer countById(String id);
}
