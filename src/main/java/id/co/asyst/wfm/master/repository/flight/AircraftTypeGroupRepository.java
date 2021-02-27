package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftTypeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftTypeGroupRepository extends BaseJpaRepository<AircraftTypeGroup, String> {

    List<AircraftTypeGroup> findByAcTypeGroupCodeContainsAndActive(String acTypeCode, ActiveEnum active);
    Page<AircraftTypeGroup> findByAcTypeGroupCodeContainsAndActive(String acTypeCode, ActiveEnum active, Pageable pageable);
    Integer countByAcTypeGroupCode(String acTypeGroupCode);
}
