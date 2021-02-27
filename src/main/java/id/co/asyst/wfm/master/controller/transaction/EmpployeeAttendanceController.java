package id.co.asyst.wfm.master.controller.transaction;

import id.co.asyst.wfm.master.model.AbsenceEnum;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.transaction.EmployeeAttendance;
import id.co.asyst.wfm.master.payload.transaction.EmployeeAttendanceInsert;
import id.co.asyst.wfm.master.response.ResponseProfile;
import id.co.asyst.wfm.master.service.transaction.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction/attendance")
public class EmpployeeAttendanceController {

    @Autowired
    EmployeeAttendanceService employeeAttendanceService;

    @GetMapping("/list")
    public List<EmployeeAttendance> getAll() {
        return (List<EmployeeAttendance>) employeeAttendanceService.findAll();
    }

    @PostMapping("/create")
    public ResponseProfile create(@Valid @RequestBody EmployeeAttendanceInsert employeeAttendanceInsert) {

        String employeeId = employeeAttendanceInsert.getEmployeeId();
        String org = employeeAttendanceInsert.getOrg();

        //Shift Current Define
        Date datetime = employeeAttendanceInsert.getTimestamp();
        LocalDate date = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        //Shift Yesterday Define
        LocalDate dateYesterday = date.minusDays(1);
        String idYesterday = employeeId.concat(org).concat(String.valueOf(dateYesterday).replaceAll("-","")).toUpperCase();
        LocalTime nowTime = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTime timeTreshold = LocalTime.parse("08:00:00");

        if (nowTime.isBefore(timeTreshold)){
            Integer attendanceCheckYesterday = employeeAttendanceService.countById(idYesterday);
            if (attendanceCheckYesterday > 0){

                EmployeeAttendance checkAttendaceYesterday = (EmployeeAttendance) employeeAttendanceService.findById(idYesterday);
                if (checkAttendaceYesterday.getActShiftEnd() == null){

                    checkAttendaceYesterday.setActShiftEnd(datetime);
                    employeeAttendanceService.saveOrUpdate(checkAttendaceYesterday);

                    EmployeeAttendance updateAttendanceYesterday= (EmployeeAttendance) employeeAttendanceService.findById(idYesterday);
                    Integer workDuration = employeeAttendanceService.getWorkDuration(dateYesterday, employeeId);
                    Integer workOvertime = employeeAttendanceService.getWorkOvertime(dateYesterday, employeeId);
                    updateAttendanceYesterday.setTotalWorkingHour(workDuration);
                    updateAttendanceYesterday.setActOvertime(workOvertime);

                    employeeAttendanceService.saveOrUpdate(updateAttendanceYesterday);
                }
                else {
                    //Submit Current Attendance
                    setEmployeeAttendanceCurrent(employeeAttendanceInsert);
                }
            }
            else {
                //Submit Current Attendance
                setEmployeeAttendanceCurrent(employeeAttendanceInsert);
            }
        }
        else {
            //Submit Current Attendance
            setEmployeeAttendanceCurrent(employeeAttendanceInsert);
        }
        return new ResponseProfile("0000", "Success", "attendance", employeeAttendanceInsert);
    }

    @GetMapping("/find/{id}")
    public EmployeeAttendance getById(@PathVariable(value = "id") Long Id) {
        return (EmployeeAttendance) employeeAttendanceService.findById(Id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long  id) {
        EmployeeAttendance employeeAttendance = (EmployeeAttendance) employeeAttendanceService.findById(id);
        employeeAttendance.setActive(ActiveEnum.N);
        employeeAttendanceService.saveOrUpdate(employeeAttendance);
        //employeeAttendanceService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public void setEmployeeAttendanceCurrent(EmployeeAttendanceInsert employeeAttendanceInsert){

        String employeeId = employeeAttendanceInsert.getEmployeeId();
        String org = employeeAttendanceInsert.getOrg();
        AbsenceEnum status = employeeAttendanceInsert.getStatus();

        //Shift Now Define
        Date datetime = employeeAttendanceInsert.getTimestamp();
        LocalDate date = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String id = employeeId.concat(org).concat(String.valueOf(date).replaceAll("-","")).toUpperCase();
        String scheduleId = (String.valueOf(date).replaceAll("-","")).concat(employeeId);

        Integer employeeAttendanceCheck = employeeAttendanceService.countById(id);
        if(employeeAttendanceCheck == 0){
            EmployeeAttendance employeeAttendance = new EmployeeAttendance();

            employeeAttendance.setEmployeeAttendanceId(id);
            employeeAttendance.setEmployeeScheduleId(scheduleId);
            employeeAttendance.setEmployeeId(employeeId);
            employeeAttendance.setOrg(org);
            employeeAttendance.setActShiftStart(datetime);

            employeeAttendanceService.saveOrUpdate(employeeAttendance);

            EmployeeAttendance updateEmployeeAttendance = (EmployeeAttendance) employeeAttendanceService.findById(id);
            String attendanceStatus = employeeAttendanceService.getStatusAttendance(date, employeeId);

            if (attendanceStatus == null){
                updateEmployeeAttendance.setAttendanceStatusCode("Absent");
            }
            else {
                updateEmployeeAttendance.setAttendanceStatusCode(attendanceStatus);
            }
            employeeAttendanceService.saveOrUpdate(updateEmployeeAttendance);
            employeeAttendanceService.updateStatusAttendance(attendanceStatus, date, employeeId);
            employeeAttendanceService.updateStatusAttendanceSchedule(attendanceStatus, date, employeeId);
        }
        else{
            EmployeeAttendance employeeAttendance = (EmployeeAttendance) employeeAttendanceService.findById(id);
            employeeAttendance.setActShiftEnd(datetime);
            employeeAttendanceService.saveOrUpdate(employeeAttendance);

            EmployeeAttendance updateEmployeeAttendance = (EmployeeAttendance) employeeAttendanceService.findById(id);
            Integer workDuration = employeeAttendanceService.getWorkDuration(date, employeeId);
            Integer workOvertime = employeeAttendanceService.getWorkOvertime(date, employeeId);
            updateEmployeeAttendance.setTotalWorkingHour(workDuration);
            updateEmployeeAttendance.setActOvertime(workOvertime);

            employeeAttendanceService.saveOrUpdate(updateEmployeeAttendance);
        }
    }
}
