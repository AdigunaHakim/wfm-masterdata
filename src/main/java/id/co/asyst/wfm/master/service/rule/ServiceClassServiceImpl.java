package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.ServiceClass;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceClassServiceImpl extends BaseServiceManager<ServiceClass, String> implements ServiceClassService<ServiceClass, String>{


    @Override
    public Collection<ServiceClass> findAll() {
        return null;
    }

    @Override
    public ServiceClass findById(String s) {
        return null;
    }

    @Override
    public ServiceClass saveOrUpdate(ServiceClass serviceClass) {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ServiceClass serviceClass) {

    }
}
