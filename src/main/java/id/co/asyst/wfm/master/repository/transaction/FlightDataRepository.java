package id.co.asyst.wfm.master.repository.transaction;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.transaction.FlightData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FlightDataRepository extends BaseJpaRepository<FlightData, String> {

    @Query(value = "SELECT DISTINCT(station) FROM flight_data", nativeQuery = true)
    List<String> getListStation();
    List<FlightData> findByTripNumberContains(String trimNumber);
    Page<FlightData> findByStationContainsAndTripNumberContainsAndPhaseContainsAndAcRegContainsAndHostPosContainsAndActive(String station, String flightId, String phase, String acReg, String hostpos, ActiveEnum active, Pageable pageable);
    Page<FlightData> findByStationContainsAndTripNumberContainsAndFlightDateAndPhaseContainsAndAcRegContainsAndHostPosContainsAndActive(String station, String flightId, LocalDate flightDate, String phase, String acReg, String hostpos, ActiveEnum active, Pageable pageable);

    @Query(value = "select * from flight_data where flight_date >= ?1 and flight_date <= ?2 and station = ?3 order by host_pos asc ", nativeQuery = true)
    List<FlightData> getFlightMonitoring(LocalDate startDate, LocalDate endDate, String station);
}
