package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AircraftTypeRepository extends BaseJpaRepository<AircraftType, String> {

    List<AircraftType> findByAcTypeCodeContainsAndActive(String acTypeCode, ActiveEnum active);
    Page<AircraftType> findByAcTypeCodeContainsAndActive(String acTypeCode, ActiveEnum active, Pageable pageable);
    Integer countByAcTypeCode (String acTypeCode);

    @Query(value = "SELECT a.* FROM aircraft_type a WHERE a.ac_type_group_code = ?1 AND a.ac_type_code LIKE %?2% AND a.active = 1" , nativeQuery = true)
    List<AircraftType> findBySelectAircraft(String acTypeGroupCode, String acTypeCode);
}