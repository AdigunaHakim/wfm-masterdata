package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.flight.HandlingType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HandlingTypeRepository extends BaseJpaRepository<HandlingType, String> {

    List<HandlingType> findByHandlingTypeCodeContains(String handlingTypeCode);
    Page<HandlingType> findByHandlingTypeCodeContains(String handlingTypeCode, Pageable pageable);
    Integer countByHandlingTypeCode(String handlingTypeCode);
}
