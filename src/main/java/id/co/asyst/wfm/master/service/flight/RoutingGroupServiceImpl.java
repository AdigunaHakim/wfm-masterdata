package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.flight.RoutingGroup;
import id.co.asyst.wfm.master.repository.flight.RoutingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RoutingGroupServiceImpl extends BaseServiceManager<RoutingGroup, String> implements RoutingGroupService<RoutingGroup, String> {

    @Autowired
    RoutingGroupRepository routingGroupRepository;


    @Override
    public Collection<RoutingGroup> findAll() {
        return (Collection<RoutingGroup>) routingGroupRepository.findAll();
    }

    @Override
    public RoutingGroup findById(String s) {
        return routingGroupRepository.findById(s).get();
    }

    @Override
    public RoutingGroup saveOrUpdate(RoutingGroup routingGroup) {
        return routingGroupRepository.save(routingGroup);
    }

    @Override
    public void deleteById(String s) {
        routingGroupRepository.deleteById(s);
    }

    @Override
    public void delete(RoutingGroup routingGroup) {
        routingGroupRepository.delete(routingGroup);
    }

    @Override
    public List<RoutingGroup> findByRoutingGroupCodeList(String routingGroupCode, ActiveEnum active) {
        return routingGroupRepository.findByRoutingGroupCodeContainsAndActive(routingGroupCode, active);
    }

    @Override
    public Page<RoutingGroup> findByRoutingGroupCodePage(String routingGroupCode, ActiveEnum active, Pageable pageable) {
        return routingGroupRepository.findByRoutingGroupCodeContainsAndActive(routingGroupCode, active, pageable);
    }

    @Override
    public Integer countByRoutingGroupCode(String routingGroupCode) {
        return routingGroupRepository.countByRoutingGroupCode(routingGroupCode);
    }
}
