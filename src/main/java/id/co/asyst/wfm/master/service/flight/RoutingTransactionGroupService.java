package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.flight.Routing;
import id.co.asyst.wfm.master.model.flight.RoutingGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoutingTransactionGroupService<T, ID> extends ServiceManager<T, ID> {

    List<Object[]> findByRouting(String routingCode);
    List<Object[]> findByRoutingGroup(String routingGroupCode);
    void deleteByRouting(String routingCode);
    void deletebyRoutingGroup(String routingGroupCode);
    List<Routing> findBySelectedRouting(String routingGroupCode, String routingCode);
    List<RoutingGroup> findBySelectedRoutingGroup(String routingCode, String routingGroupCode);
}
