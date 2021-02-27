package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.flight.RoutingTransactionGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoutingTransactionGroupRepository extends BaseJpaRepository<RoutingTransactionGroup, Long>{

    @Query(value = "SELECT q.routing_code, q.routing_group_code FROM routing_transaction_group q LEFT JOIN routing x ON q.routing_code=x.routing_code " +
            "LEFT JOIN routing_group y ON q.routing_group_code=y.routing_group_code WHERE q.routing_group_code = ?1 ORDER BY routing_code ASC" , nativeQuery = true)
    List<Object[]> findByRoutingGroupCode(String RoutingGroupCode);

    @Query(value = "SELECT q.routing_code, q.routing_group_code FROM routing_transaction_group q LEFT JOIN routing x ON q.routing_code=x.routing_code " +
            "LEFT JOIN routing_group y ON q.routing_group_code=y.routing_group_code WHERE q.routing_code = ?1 ORDER BY routing_group_code ASC" , nativeQuery = true)
    List<Object[]> findByRoutingCode (String airlineCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM routing_transaction_group WHERE routing_group_code = ?1", nativeQuery = true)
    void deleteByRoutingGroupCode(String routingGroupCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM routing_transaction_group WHERE routing_code = ?1", nativeQuery = true)
    void deleteByRoutingCode(String routingCode);
}
