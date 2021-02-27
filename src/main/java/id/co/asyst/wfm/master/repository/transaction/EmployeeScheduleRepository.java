package id.co.asyst.wfm.master.repository.transaction;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.transaction.EmployeeSchedule;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeScheduleRepository extends BaseJpaRepository<EmployeeSchedule, String>{

    @Query(value = "SELECT a.* FROM employee_schedule a WHERE " +
            "EXTRACT(MONTH FROM a.date) = EXTRACT(MONTH FROM CAST(?1 AS DATE)) " +
            "AND EXTRACT(YEAR FROM a.date) = EXTRACT(YEAR FROM CAST(?1 AS DATE)) " +
            "AND a.employee_id = ?2", nativeQuery = true)
    List<EmployeeSchedule> getScheduleMonthly(LocalDate date, String employeeId);

    @Query(value = "SELECT a.* FROM employee_schedule a WHERE a.date = ?1 " +
            "AND a.employee_id = ?2", nativeQuery = true)
    EmployeeSchedule getScheduleDetail(LocalDate date, String employeeId);


    //Attendace Reminder
    @Query(value = "select * from employee_schedule where date >= ?1 and date <= ?2 and " +
            "attendance_status in ('Absent') and attendance_reminder not in('Absent')",
            nativeQuery = true)
    List<EmployeeSchedule> getScheduleCheck(LocalDate startDate, LocalDate endDate);

    @Modifying
    @Transactional
    @Query(value = "UPDATE task_list SET attendance_reminder = ?1 WHERE shift_date = ?2 AND employee_id =?3", nativeQuery = true)
    int updateAttendanceReminder(String status, LocalDate date, String employeeId);
}
