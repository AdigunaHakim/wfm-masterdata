package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.RoutingGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoutingGroupService<T,ID> extends ServiceManager<T,ID>{

    List<RoutingGroup> findByRoutingGroupCodeList(String routingGroupCode, ActiveEnum active);
    Page<RoutingGroup> findByRoutingGroupCodePage(String routingGroupCode, ActiveEnum active, Pageable pageable);
    Integer countByRoutingGroupCode(String routingGroupCode);
}
