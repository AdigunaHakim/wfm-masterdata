package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.Routing;
import id.co.asyst.wfm.master.repository.flight.RoutingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RoutingServiceImpl extends BaseServiceManager<Routing, String> implements RoutingService<Routing, String>{

    @Autowired
    RoutingRepository routingRepository;

    @Override
    public Collection<Routing> findAll() {
        return (Collection<Routing>) routingRepository.findAll();
    }

    @Override
    public Routing findById(String s) {
        return routingRepository.findById(s).get();
    }

    @Override
    public Routing saveOrUpdate(Routing routing) {
        return routingRepository.save(routing);
    }

    @Override
    public void deleteById(String s) {
        routingRepository.deleteById(s);
    }

    @Override
    public void delete(Routing routing) {
        routingRepository.delete(routing);
    }

    @Override
    public List<Routing> findByRoutingCodeList(String routingCode, ActiveEnum active) {
        return routingRepository.findByRoutingCodeContainsAndActive(routingCode, active);
    }

    @Override
    public Page<Routing> findByRoutingCodePage(String routingCode, ActiveEnum active, Pageable pageable) {
        return routingRepository.findByRoutingCodeContainsAndActive(routingCode, active, pageable);
    }

    @Override
    public Integer countById(String id) {
        return routingRepository.countByRoutingCode(id);
    }
}
