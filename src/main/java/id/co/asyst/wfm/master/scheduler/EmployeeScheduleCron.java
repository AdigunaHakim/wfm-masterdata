package id.co.asyst.wfm.master.scheduler;

import id.co.asyst.wfm.master.model.transaction.EmployeeSchedule;
import id.co.asyst.wfm.master.service.transaction.EmployeeScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Component
public class EmployeeScheduleCron {

    @Autowired
    EmployeeScheduleService employeeScheduleService;

    @Scheduled(cron = "0 0 * * * *")
    public void check60Minutes(){
        Date date = new Date();
        LocalDate endDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = endDate.minusDays(1);
        LocalDateTime nowDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        List<EmployeeSchedule> scheduleCheck = employeeScheduleService.getScheduleCheck(startDate, endDate);

        if (!scheduleCheck.isEmpty()){
            for (int i = 0; i < scheduleCheck.size(); i++){

                if (scheduleCheck.get(i).getShiftIndicator() == 1){

                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate().plusDays(1), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }

                else {
                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }
            }
        }
    }

    @Scheduled(cron = "0 31 * * * *")
    public void check30Minutes(){
        Date date = new Date();
        LocalDate endDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = endDate.minusDays(1);
        LocalDateTime nowDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        List<EmployeeSchedule> scheduleCheck = employeeScheduleService.getScheduleCheck(startDate, endDate);

        if (!scheduleCheck.isEmpty()){
            for (int i = 0; i < scheduleCheck.size(); i++){

                if (scheduleCheck.get(i).getShiftIndicator() == 1){

                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate().plusDays(1), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }

                else {
                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }
            }
        }
    }

    @Scheduled(cron = "0 44 * * * *")
    public void check15Minutes(){
        Date date = new Date();
        LocalDate endDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = endDate.minusDays(1);
        LocalDateTime nowDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        List<EmployeeSchedule> scheduleCheck = employeeScheduleService.getScheduleCheck(startDate, endDate);

        if (!scheduleCheck.isEmpty()){
            for (int i = 0; i < scheduleCheck.size(); i++){

                if (scheduleCheck.get(i).getShiftIndicator() == 1){

                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate().plusDays(1), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }

                else {
                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }
            }
        }
    }

    @Scheduled(cron = "0 56 * * * *")
    public void check5Minutes(){
        Date date = new Date();
        LocalDate endDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = endDate.minusDays(1);
        LocalDateTime nowDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        List<EmployeeSchedule> scheduleCheck = employeeScheduleService.getScheduleCheck(startDate, endDate);

        if (!scheduleCheck.isEmpty()){
            for (int i = 0; i < scheduleCheck.size(); i++){

                if (scheduleCheck.get(i).getShiftIndicator() == 1){

                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate().plusDays(1), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }

                else {
                    LocalDateTime startTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftStarttime());
                    LocalDateTime endTime = LocalDateTime.of(scheduleCheck.get(i).getDate(), scheduleCheck.get(i).getShiftEndtime());

                    assignReminderStatus(scheduleCheck.get(i), nowDateTime, startTime, endTime);
                }
            }
        }
    }

    public void assignReminderStatus(EmployeeSchedule employeeSchedule, LocalDateTime nowDateTime, LocalDateTime startTime, LocalDateTime endTime){

        if (nowDateTime.isBefore(endTime)){
            long minutes = nowDateTime.until( startTime, ChronoUnit.MINUTES);

            if (minutes <= 60){
                if (minutes <= 5){
                    employeeSchedule.setAttendanceReminder("Late");
                    employeeScheduleService.saveOrUpdate(employeeSchedule);
                    employeeScheduleService.updateAttendanceReminder("Late", employeeSchedule.getDate(), employeeSchedule.getEmployeeId());
                }
                else if (minutes >=6 && minutes <16){
                    employeeSchedule.setAttendanceReminder("Hard Warning");
                    employeeScheduleService.saveOrUpdate(employeeSchedule);
                    employeeScheduleService.updateAttendanceReminder("Hard Warning", employeeSchedule.getDate(), employeeSchedule.getEmployeeId());
                }
                else if (minutes >= 16 && minutes <31){
                    employeeSchedule.setAttendanceReminder("Warning");
                    employeeScheduleService.saveOrUpdate(employeeSchedule);
                    employeeScheduleService.updateAttendanceReminder("Warning", employeeSchedule.getDate(), employeeSchedule.getEmployeeId());
                }
                else {
                    employeeSchedule.setAttendanceReminder("Safe");
                    employeeScheduleService.saveOrUpdate(employeeSchedule);
                    employeeScheduleService.updateAttendanceReminder("Safe", employeeSchedule.getDate(), employeeSchedule.getEmployeeId());
                }
            }
        }

        else {
            employeeSchedule.setAttendanceReminder("Absent");
            employeeScheduleService.saveOrUpdate(employeeSchedule);
            employeeScheduleService.updateAttendanceReminder("Absent", employeeSchedule.getDate(), employeeSchedule.getEmployeeId());
        }
    }
}
