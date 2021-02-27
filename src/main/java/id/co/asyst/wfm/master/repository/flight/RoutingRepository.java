package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.Routing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoutingRepository extends BaseJpaRepository<Routing, String> {

    List<Routing> findByRoutingCodeContainsAndActive(String routingCode, ActiveEnum active);
    Page<Routing> findByRoutingCodeContainsAndActive(String routingCode, ActiveEnum active, Pageable pageable);
    Integer countByRoutingCode(String routingCode);

    @Query(value = "SELECT b.* FROM routing_transaction_group a LEFT JOIN routing b ON a.routing_code=b.routing_code WHERE a.routing_group_code = ?1 " +
            "AND a.routing_code LIKE %?2% ORDER BY b.routing_code ASC" , nativeQuery = true)
    List<Routing> findBySelectedRouting (String routingGroupCode, String routingCode);

}
