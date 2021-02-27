package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.AirlineGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirlineGroupRepository extends BaseJpaRepository<AirlineGroup, String> {
    List<AirlineGroup> findByAirlineGroupCodeContainsAndActive(String airlineGroupCode, ActiveEnum active);
    Page<AirlineGroup> findByAirlineGroupCodeContainsAndActive(String airlineGroupCode, ActiveEnum active, Pageable pageable);
    Integer countByAirlineGroupCode(String airlineGroupCode);

    @Query(value = "SELECT b.* FROM airline_transaction_group a LEFT JOIN airline_group b ON a.airline_group_code=b.airline_group_code WHERE a.airline_code = ?1 " +
            "AND a.airline_group_code LIKE %?2% ORDER BY b.airline_group_code ASC" , nativeQuery = true)
    List<AirlineGroup> findBySelectedAirlineGroup (String airlineCode, String airlineGroupCode);
}