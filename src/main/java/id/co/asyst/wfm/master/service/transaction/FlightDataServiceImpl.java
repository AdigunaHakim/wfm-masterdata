package id.co.asyst.wfm.master.service.transaction;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.transaction.FlightData;
import id.co.asyst.wfm.master.repository.transaction.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class FlightDataServiceImpl extends BaseServiceManager<FlightData, String> implements FlightDataService<FlightData,String>{

    @Autowired
    FlightDataRepository flightDataRepository;

    @Override
    public Collection<FlightData> findAll() {
        return flightDataRepository.findAll();
    }

    @Override
    public FlightData findById(String aLong) {
        return flightDataRepository.findById(aLong).get();
    }

    @Override
    public FlightData saveOrUpdate(FlightData flightData) {
        return flightDataRepository.save(flightData);
    }

    @Override
    public void deleteById(String aLong) {
        flightDataRepository.deleteById(aLong);
    }

    @Override
    public void delete(FlightData flightData) {
        flightDataRepository.delete(flightData);
    }

    @Override
    public List<String> getListStation() {
        return flightDataRepository.getListStation();
    }

    @Override
    public List<FlightData> search(String tripNumber) {
        return flightDataRepository.findByTripNumberContains(tripNumber);
    }

    @Override
    public Page<FlightData> search(String station, String flightId, String phase, String acReg, String hostpos, ActiveEnum active, Pageable pageable) {
        return flightDataRepository.findByStationContainsAndTripNumberContainsAndPhaseContainsAndAcRegContainsAndHostPosContainsAndActive(station, flightId, phase, acReg, hostpos, active, pageable);
    }

    @Override
    public Page<FlightData> searchWithDate(String station, String flightId, LocalDate flightDate, String phase, String acReg, String hostpos, ActiveEnum active, Pageable pageable) {
        return flightDataRepository.findByStationContainsAndTripNumberContainsAndFlightDateAndPhaseContainsAndAcRegContainsAndHostPosContainsAndActive(station, flightId, flightDate, phase, acReg, hostpos, active, pageable);
    }

    @Override
    public List<FlightData> getFlightMonitoring(LocalDate startDate, LocalDate endDate, String station) {
        return flightDataRepository.getFlightMonitoring(startDate, endDate, station);
    }
}
