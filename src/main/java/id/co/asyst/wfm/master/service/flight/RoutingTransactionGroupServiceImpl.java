package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.flight.Routing;
import id.co.asyst.wfm.master.model.flight.RoutingGroup;
import id.co.asyst.wfm.master.model.flight.RoutingTransactionGroup;
import id.co.asyst.wfm.master.repository.flight.RoutingGroupRepository;
import id.co.asyst.wfm.master.repository.flight.RoutingRepository;
import id.co.asyst.wfm.master.repository.flight.RoutingTransactionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RoutingTransactionGroupServiceImpl extends BaseServiceManager<RoutingTransactionGroup, Long> implements RoutingTransactionGroupService<RoutingTransactionGroup, Long>{

    @Autowired
    RoutingTransactionGroupRepository routingTransactionGroupRepository;

    @Autowired
    RoutingGroupRepository routingGroupRepository;

    @Autowired
    RoutingRepository routingRepository;

    @Override
    public List<Object[]> findByRouting(String routingCode) {
        return routingTransactionGroupRepository.findByRoutingCode(routingCode);
    }

    @Override
    public List<Object[]> findByRoutingGroup(String routingGroupCode) {
        return routingTransactionGroupRepository.findByRoutingGroupCode(routingGroupCode);
    }

    @Override
    public void deleteByRouting(String routingCode) {
        routingTransactionGroupRepository.deleteByRoutingCode(routingCode);
    }

    @Override
    public void deletebyRoutingGroup(String routingGroupCode) {
        routingTransactionGroupRepository.deleteByRoutingGroupCode(routingGroupCode);
    }

    @Override
    public List<Routing> findBySelectedRouting(String routingGroupCode, String routingCode) {
        return routingRepository.findBySelectedRouting(routingGroupCode, routingCode);
    }

    @Override
    public List<RoutingGroup> findBySelectedRoutingGroup(String routingCode, String routingGroupCode) {
        return routingGroupRepository.findBySelectedRoutingGroup(routingCode, routingGroupCode );
    }

    @Override
    public Collection<RoutingTransactionGroup> findAll() {
        return routingTransactionGroupRepository.findAll();
    }

    @Override
    public RoutingTransactionGroup findById(Long aLong) {
        return routingTransactionGroupRepository.findById(aLong).get();
    }

    @Override
    public RoutingTransactionGroup saveOrUpdate(RoutingTransactionGroup routingTransactionGroup) {
        return routingTransactionGroupRepository.save(routingTransactionGroup);
    }

    @Override
    public void deleteById(Long aLong) {
        routingTransactionGroupRepository.deleteById(aLong);
    }

    @Override
    public void delete(RoutingTransactionGroup routingTransactionGroup) {

    }
}
