package id.co.asyst.wfm.master.controller.transaction;

import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.transaction.EmployeeSchedule;
import id.co.asyst.wfm.master.service.transaction.EmployeeScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transaction/employee-schedule")
public class EmployeeScheduleController {

    @Autowired
    EmployeeScheduleService employeeScheduleService;

    @GetMapping("/list")
    public List<EmployeeSchedule> getAll() {
        return (List<EmployeeSchedule>) employeeScheduleService.findAll();
    }

    @GetMapping("/list/monthly/{date}/{employeeId}")
    public List<EmployeeSchedule> getScheduleMonthly(@PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                     @PathVariable(value = "employeeId") String employeeId) {
        return (List<EmployeeSchedule>) employeeScheduleService.getScheduleMonthly(date, employeeId);
    }

    @GetMapping("/list/detail/{date}/{employeeId}")
    public EmployeeSchedule getScheduleDetail(@PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                     @PathVariable(value = "employeeId") String employeeId) {
        return (EmployeeSchedule) employeeScheduleService.getScheduleDetail(date, employeeId);
    }

    @PostMapping("/create")
    public EmployeeSchedule create(@Valid @RequestBody EmployeeSchedule employeeSchedule) {
        return (EmployeeSchedule) employeeScheduleService.saveOrUpdate(employeeSchedule);
    }

    @GetMapping("/find/{id}")
    public EmployeeSchedule getById(@PathVariable(value = "id") String Id) {
        return (EmployeeSchedule) employeeScheduleService.findById(Id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {

        EmployeeSchedule employeeSchedule = (EmployeeSchedule) employeeScheduleService.findById(id);
        employeeSchedule.setActive(ActiveEnum.N);
        employeeScheduleService.saveOrUpdate(employeeSchedule);
        //employeeScheduleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
