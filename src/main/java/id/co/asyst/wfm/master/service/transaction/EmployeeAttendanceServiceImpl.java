package id.co.asyst.wfm.master.service.transaction;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.transaction.EmployeeAttendance;
import id.co.asyst.wfm.master.repository.transaction.EmployeeAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class EmployeeAttendanceServiceImpl extends BaseServiceManager<EmployeeAttendance, String> implements EmployeeAttendanceService<EmployeeAttendance, String> {

    @Autowired
    EmployeeAttendanceRepository employeeAttendanceRepository;

    @Override
    public Collection<EmployeeAttendance> findAll() {
        return employeeAttendanceRepository.findAll();
    }

    @Override
    public EmployeeAttendance findById(String s) {
        return employeeAttendanceRepository.findById(s).get();
    }

    @Override
    public EmployeeAttendance saveOrUpdate(EmployeeAttendance employeeAttendance) {
        return employeeAttendanceRepository.save(employeeAttendance);
    }

    @Override
    public void deleteById(String s) {
        employeeAttendanceRepository.deleteById(s);
    }

    @Override
    public void delete(EmployeeAttendance employeeAttendance) {
        delete(employeeAttendance);
    }

    @Override
    public Integer countById(String id) {
        return employeeAttendanceRepository.countByEmployeeAttendanceId(id);
    }

    @Override
    public String getStatusAttendance(LocalDate date, String employeeId) {
        return employeeAttendanceRepository.getStatusAttendance(date, employeeId);
    }

    @Override
    public int updateStatusAttendance(String status, LocalDate date, String employeeId) {
        return employeeAttendanceRepository.updateStatusAttendance(status, date, employeeId);
    }

    @Override
    public int updateStatusAttendanceSchedule(String status, LocalDate date, String employeeId) {
        return employeeAttendanceRepository.updateStatusAttendanceSchedule(status, date, employeeId);
    }

    @Override
    public Integer getWorkDuration(LocalDate date, String employeeId) {
        return employeeAttendanceRepository.getWorkDuration(date, employeeId);
    }

    @Override
    public Integer getWorkOvertime(LocalDate date, String employeeId) {
        return employeeAttendanceRepository.getWorkOvertime(date, employeeId);
    }
}
