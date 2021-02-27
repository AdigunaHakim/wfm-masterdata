package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirlineRepository extends BaseJpaRepository<Airline, String> {

    List<Airline> findByAirlineCodeContainsAndActive(String airlineCode, ActiveEnum active);
    Page<Airline> findByAirlineCodeContainsAndActive(String airlineCode, ActiveEnum active, Pageable pageable);
    Integer countByAirlineCode(String airlineCode);

    @Query(value = "SELECT b.* FROM airline_transaction_group a LEFT JOIN airline b ON a.airline_code=b.airline_code WHERE a.airline_group_code = ?1 " +
            "AND a.airline_code LIKE %?2% ORDER BY b.airline_code ASC" , nativeQuery = true)
    List<Airline> findBySelectedAirline (String airlineGroupCode, String airlineCode);
}
