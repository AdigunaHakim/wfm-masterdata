package id.co.asyst.wfm.master.repository.transaction;


import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.transaction.EmployeeAttendance;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface EmployeeAttendanceRepository extends BaseJpaRepository<EmployeeAttendance, String>{

    @Query(value = "SELECT DISTINCT attendance_status FROM transaction_schedule_attendance WHERE shift_date = ?1 " +
            "AND employee_id = ?2", nativeQuery = true)
    String getStatusAttendance(LocalDate date, String employeeId);

    @Query(value = "SELECT work_duration FROM transaction_schedule_attendance WHERE shift_date = ?1 " +
            "AND employee_id = ?2", nativeQuery = true)
    Integer getWorkDuration(LocalDate date, String employeeId);

    @Query(value = "SELECT work_overtime FROM transaction_schedule_attendance WHERE shift_date = ?1 " +
            "AND employee_id = ?2", nativeQuery = true)
    Integer getWorkOvertime(LocalDate date, String employeeId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE task_list SET attendance_status = ?1 WHERE shift_date = ?2 AND employee_id =?3", nativeQuery = true)
    int updateStatusAttendance(String status, LocalDate date, String employeeId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee_schedule SET attendance_status = ?1 WHERE date = ?2 AND employee_id =?3", nativeQuery = true)
    int updateStatusAttendanceSchedule(String status, LocalDate date, String employeeId);

    Integer countByEmployeeAttendanceId(String id);

}
