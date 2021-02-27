package id.co.asyst.wfm.master.service.transaction;

import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.master.model.transaction.EmployeeSchedule;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeScheduleService<T,ID> extends ServiceManager <T, ID> {

    List<EmployeeSchedule> getScheduleMonthly(LocalDate date, String employeeId);
    EmployeeSchedule getScheduleDetail(LocalDate date, String employeeId);

    //Attendance Reminder
    List<EmployeeSchedule> getScheduleCheck(LocalDate startDate, LocalDate endDate);
    void updateAttendanceReminder(String status, LocalDate date, String employeeId);
}
