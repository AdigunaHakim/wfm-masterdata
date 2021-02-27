package id.co.asyst.wfm.master.service.transaction;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.transaction.FlightData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface FlightDataService<T,ID> extends ServiceManager<T,ID> {

    List<String> getListStation();
    List<FlightData> search(String tripNumber);
    Page<FlightData> search(String station, String flightId, String phase, String acReg, String hostpos, ActiveEnum active, Pageable pageable);
    Page<FlightData> searchWithDate(String station, String flightId, LocalDate flightDate, String phase, String acReg, String hostpos, ActiveEnum active, Pageable pageable);
    List<FlightData> getFlightMonitoring(LocalDate startDate, LocalDate endDate, String station);
}
