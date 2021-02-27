package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.ServiceGroup;
import id.co.asyst.wfm.master.repository.rules.ServiceGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceGroupServiceImpl extends BaseServiceManager<ServiceGroup, String> implements ServiceGroupService<ServiceGroup, String> {

    @Autowired
    ServiceGroupRepository serviceGroupRepository;

    @Override
    public Collection<ServiceGroup> findAll() {
        return (Collection<ServiceGroup>) serviceGroupRepository.findAll();
    }

    @Override
    public ServiceGroup findById(String s) {
        return serviceGroupRepository.findById(s).get();
    }

    @Override
    public ServiceGroup saveOrUpdate(ServiceGroup serviceGroup) {
        return serviceGroupRepository.save(serviceGroup);
    }

    @Override
    public void deleteById(String s) {
        serviceGroupRepository.deleteById(s);
    }

    @Override
    public void delete(ServiceGroup serviceGroup) {
        serviceGroupRepository.delete(serviceGroup);
    }
}
