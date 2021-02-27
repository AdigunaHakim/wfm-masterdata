package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Routing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoutingService<T,ID> extends ServiceManager<T,ID> {

    List<Routing> findByRoutingCodeList(String routingCode, ActiveEnum active);
    Page<Routing> findByRoutingCodePage(String routingCode, ActiveEnum active, Pageable pageable);
    Integer countById(String id);
}
