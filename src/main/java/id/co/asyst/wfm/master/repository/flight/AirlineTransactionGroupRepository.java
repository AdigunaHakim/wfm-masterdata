package id.co.asyst.wfm.master.repository.flight;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.employee.EmployeeFunction;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.AirlineTransactionGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AirlineTransactionGroupRepository extends BaseJpaRepository<AirlineTransactionGroup, Long> {

    @Query(value = "SELECT q.airline_code, q.airline_group_code FROM airline_transaction_group q LEFT JOIN airline x ON q.airline_code=x.airline_code " +
            "LEFT JOIN airline_group y ON q.airline_group_code=y.airline_group_code WHERE q.airline_group_code = ?1 ORDER BY airline_code ASC" , nativeQuery = true)
    List<Object[]> findByAirlineGroupCode(String AirlineGroupCode);

    @Query(value = "SELECT q.airline_code, q.airline_group_code FROM airline_transaction_group q LEFT JOIN airline x ON q.airline_code=x.airline_code " +
            "LEFT JOIN airline_group y ON q.airline_group_code=y.airline_group_code WHERE q.airline_code = ?1 ORDER BY airline_group_code ASC" , nativeQuery = true)
    List<Object[]> findByAirlineCode (String airlineCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM airline_transaction_group WHERE airline_group_code = ?1", nativeQuery = true)
    void deleteByairlineGroupCode(String airlineGroupCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM airline_transaction_group WHERE airline_code = ?1", nativeQuery = true)
    void deleteByairlineCode(String airlineCode);
}
