package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.ArrivalProfile;
import id.co.asyst.wfm.master.repository.rules.ArrivalProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArrivalProfileServiceImpl extends BaseServiceManager<ArrivalProfile, String> implements ArrivalProfileService<ArrivalProfile, String> {

    @Autowired
    ArrivalProfileRepository arrivalProfileRepository;

    @Override
    public Collection<ArrivalProfile> findAll() {
        return (Collection<ArrivalProfile>) arrivalProfileRepository.findAll();
    }

    @Override
    public ArrivalProfile findById(String s) {
        return arrivalProfileRepository.findById(s).get();
    }

    @Override
    public ArrivalProfile saveOrUpdate(ArrivalProfile arrivalProfile) {
        return arrivalProfileRepository.save(arrivalProfile);
    }

    @Override
    public void deleteById(String s) {
        arrivalProfileRepository.deleteById(s);
    }

    @Override
    public void delete(ArrivalProfile arrivalProfile) {
        arrivalProfileRepository.delete(arrivalProfile);
    }
}
