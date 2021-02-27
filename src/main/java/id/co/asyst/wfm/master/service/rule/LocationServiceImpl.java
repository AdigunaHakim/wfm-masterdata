package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.Location;
import id.co.asyst.wfm.master.repository.rules.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocationServiceImpl extends BaseServiceManager<Location, String> implements LocationService<Location, String> {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Collection<Location> findAll() {
        return (Collection<Location>) locationRepository.findAll();
    }

    @Override
    public Location findById(String s) {
        return locationRepository.findById(s).get();
    }

    @Override
    public Location saveOrUpdate(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(String s) {
        locationRepository.deleteById(s);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }
}
