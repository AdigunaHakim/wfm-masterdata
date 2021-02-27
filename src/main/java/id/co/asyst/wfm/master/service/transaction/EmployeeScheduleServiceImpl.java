package id.co.asyst.wfm.master.service.transaction;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.transaction.EmployeeSchedule;
import id.co.asyst.wfm.master.repository.transaction.EmployeeScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeScheduleServiceImpl extends BaseServiceManager<EmployeeSchedule, String> implements EmployeeScheduleService<EmployeeSchedule, String> {

    @Autowired
    EmployeeScheduleRepository employeeScheduleRepository;

    @Override
    public Collection<EmployeeSchedule> findAll() {
        return employeeScheduleRepository.findAll();
    }

    @Override
    public EmployeeSchedule findById(String s) {
        return employeeScheduleRepository.findById(s).get();
    }

    @Override
    public EmployeeSchedule saveOrUpdate(EmployeeSchedule employeeSchedule) {
        return employeeScheduleRepository.save(employeeSchedule);
    }

    @Override
    public void deleteById(String s) {
        employeeScheduleRepository.deleteById(s);
    }

    @Override
    public void delete(EmployeeSchedule employeeSchedule) {
        employeeScheduleRepository.delete(employeeSchedule);
    }

    @Override
    public List<EmployeeSchedule> getScheduleMonthly(LocalDate date, String employeeId) {
        return employeeScheduleRepository.getScheduleMonthly(date, employeeId);
    }

    @Override
    public EmployeeSchedule getScheduleDetail(LocalDate date, String employeeId) {
        return employeeScheduleRepository.getScheduleDetail(date, employeeId);
    }

    @Override
    public List<EmployeeSchedule> getScheduleCheck(LocalDate startDate, LocalDate endDate) {
        return employeeScheduleRepository.getScheduleCheck(startDate, endDate);
    }

    @Override
    public void updateAttendanceReminder(String status, LocalDate date, String employeeId) {
        employeeScheduleRepository.updateAttendanceReminder(status, date, employeeId);
    }
}
