package id.co.asyst.wfm.master.service.transaction;

import id.co.asyst.wfm.core.service.ServiceManager;

import java.time.LocalDate;

public interface EmployeeAttendanceService<T,ID>  extends ServiceManager<T,ID> {

    Integer countById(String id);
    String getStatusAttendance(LocalDate date, String employeeId);
    Integer getWorkDuration(LocalDate date, String employeeId);
    Integer getWorkOvertime(LocalDate date, String employeeId);
    int updateStatusAttendance(String status, LocalDate date, String employeeId);
    int updateStatusAttendanceSchedule(String status, LocalDate date, String employeeId);
}
