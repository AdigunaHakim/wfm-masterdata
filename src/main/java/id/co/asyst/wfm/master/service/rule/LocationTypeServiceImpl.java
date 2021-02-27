package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.LocationType;
import id.co.asyst.wfm.master.repository.rules.LocationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocationTypeServiceImpl extends BaseServiceManager<LocationType, String> implements LocationTypeService<LocationType, String> {

    @Autowired
    LocationTypeRepository locationTypeRepository;

    @Override
    public Collection<LocationType> findAll() {
        return (Collection<LocationType>) locationTypeRepository.findAll();
    }

    @Override
    public LocationType findById(String s) {
        return locationTypeRepository.findById(s).get();
    }

    @Override
    public LocationType saveOrUpdate(LocationType locationType) {
        return locationTypeRepository.save(locationType);
    }

    @Override
    public void deleteById(String s) {
        locationTypeRepository.deleteById(s);
    }

    @Override
    public void delete(LocationType locationType) {
        locationTypeRepository.delete(locationType);
    }
}
