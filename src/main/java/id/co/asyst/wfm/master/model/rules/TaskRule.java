package id.co.asyst.wfm.master.model.rules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.OperationDayEnum;
import id.co.asyst.wfm.master.model.PhaseEnum;
import id.co.asyst.wfm.master.model.employee.EmployeeGroup;
import id.co.asyst.wfm.master.model.employee.Qualification;
import id.co.asyst.wfm.master.model.flight.AircraftType;
import id.co.asyst.wfm.master.model.flight.Airline;
import id.co.asyst.wfm.master.model.flight.Routing;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "TASK_RULE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "lastUpdated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class TaskRule extends BaseModel {

    private static final long serialVersionUID = 6411976430617392977L;

    @Id
    @Column(name = "TASK_CODE", length = 10)
    private String taskCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TASK_TYPE_CODE")
    private TaskType taskTypes;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AIRLINE_CODE")
    private Airline airlines;

    @Column(name = "PHASE")
    private PhaseEnum phase;

    @Column(name = "TRIP_NUMBER",length = 5)
    private String tripNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AC_TYPE_CODE")
    private AircraftType aircraftTypes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROUTING_CODE")
    private Routing routings;

    @Column(name = "DAY")
    private OperationDayEnum day;

    @Column(name = "START_TIME", length = 5)
    private Integer startTime;

    @Column(name = "END_TIME", length = 5)
    private Integer endTime;

    @Column(name = "START_STATIC")
    private Time startStatic;

    @Column(name = "END_STATIC")
    private Time endStatic;

    @Column(name = "SETUP", length = 5)
    private Integer setup;

    @Column(name = "CLEAN_UP", length = 5)
    private Integer cleanUp;

    @Column(name = "COUNT", length = 5)
    private Integer count;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUALIFICATION_CODE")
    private Qualification qualifications;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_GROUP_CODE")
    private EmployeeGroup employeeGroups;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_CODE")
    private Location locations;

    @Column(name = "PRIORITY", length = 5)
    private Integer priority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLOR_CODE")
    private Color colors;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public TaskType getTaskTypes() {
        return taskTypes;
    }

    public void setTaskTypes(TaskType taskTypes) {
        this.taskTypes = taskTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airline getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline airlines) {
        this.airlines = airlines;
    }

    public PhaseEnum getPhase() {
        return phase;
    }

    public void setPhase(PhaseEnum phase) {
        this.phase = phase;
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public AircraftType getAircraftTypes() {
        return aircraftTypes;
    }

    public void setAircraftTypes(AircraftType aircraftTypes) {
        this.aircraftTypes = aircraftTypes;
    }

    public Routing getRoutings() {
        return routings;
    }

    public void setRoutings(Routing routings) {
        this.routings = routings;
    }

    public OperationDayEnum getDay() {
        return day;
    }

    public void setDay(OperationDayEnum day) {
        this.day = day;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Time getStartStatic() {
        return startStatic;
    }

    public void setStartStatic(Time startStatic) {
        this.startStatic = startStatic;
    }

    public Time getEndStatic() {
        return endStatic;
    }

    public void setEndStatic(Time endStatic) {
        this.endStatic = endStatic;
    }

    public Integer getSetup() {
        return setup;
    }

    public void setSetup(Integer setup) {
        this.setup = setup;
    }

    public Integer getCleanUp() {
        return cleanUp;
    }

    public void setCleanUp(Integer cleanUp) {
        this.cleanUp = cleanUp;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Qualification getQualifications() {
        return qualifications;
    }

    public void setQualifications(Qualification qualifications) {
        this.qualifications = qualifications;
    }

    public EmployeeGroup getEmployeeGroups() {
        return employeeGroups;
    }

    public void setEmployeeGroups(EmployeeGroup employeeGroups) {
        this.employeeGroups = employeeGroups;
    }

    public Location getLocations() {
        return locations;
    }

    public void setLocations(Location locations) {
        this.locations = locations;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Color getColors() {
        return colors;
    }

    public void setColors(Color colors) {
        this.colors = colors;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
