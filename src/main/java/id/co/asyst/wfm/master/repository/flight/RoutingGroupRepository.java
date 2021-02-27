package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Routing;
import id.co.asyst.wfm.master.model.flight.RoutingGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoutingGroupRepository extends BaseJpaRepository<RoutingGroup, String> {

    List<RoutingGroup> findByRoutingGroupCodeContainsAndActive(String routingGroupCode, ActiveEnum active);
    Page<RoutingGroup> findByRoutingGroupCodeContainsAndActive(String routingGroupCode, ActiveEnum active, Pageable pageable);
    Integer countByRoutingGroupCode(String routingGroupCode);

    @Query(value = "SELECT b.* FROM routing_transaction_group a LEFT JOIN routing_group b ON a.routing_group_code=b.routing_group_code WHERE a.routing_code = ?1 " +
            "AND a.routing_group_code LIKE %?2% ORDER BY b.routing_group_code ASC" , nativeQuery = true)
    List<RoutingGroup> findBySelectedRoutingGroup (String routingCode, String routingGroupCode);
}
