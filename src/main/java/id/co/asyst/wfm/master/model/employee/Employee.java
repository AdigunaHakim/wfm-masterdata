package id.co.asyst.wfm.master.model.employee;

import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.GenderEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Employee extends BaseModel
{

    private static final long serialVersionUID = 2982112810442854318L;

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_GROUP_CODE")
    private EmployeeGroup employeeGroups;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "PUBLISHED_NAME", nullable = false, length = 100)
    private String publishedName;

    @Column(name = "BIRTH_PLACE", length = 50)
    private String birthPlace;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "GENDER", nullable = false)
    private GenderEnum gender;

    @Column(name = "ADDRESS", length = 250)
    private String address;

    @Column(name = "POSTAL_CODE", length = 10)
    private String postalCode;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "PROVINCE", length = 50)
    private String province;

    @Column(name = "NATIONALITY", nullable = false, length = 2)
    private String nationality;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name ="PHONE", length = 20)
    private String phone;

    @Column(name = "MOBILE_PHONE", length = 20)
    private String mobilePhone;

    @Column(name = "JOIN_DATE")
    private LocalDate joinDate;

    @Column(name = "RESIGNATION_DATE")
    private LocalDate resignationDate;

    @Column(name = "ENABLE_RESIGNATION")
    private Integer enableResignation;

    @Column(name = "LAST_EDUCATION", length = 50)
    private String lastEducation;

    @Column(name = "HAS_ACCOUNT")
    private ActiveEnum hasAccount;

    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeGroup getEmployeeGroups() {
        return employeeGroups;
    }

    public void setEmployeeGroups(EmployeeGroup employeeGroups) {
        this.employeeGroups = employeeGroups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPublishedName() {
        return publishedName;
    }

    public void setPublishedName(String publishedName) {
        this.publishedName = publishedName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(LocalDate resignationDate) {
        this.resignationDate = resignationDate;
    }

    public Integer getEnableResignation() {
        return enableResignation;
    }

    public void setEnableResignation(Integer enableResignation) {
        this.enableResignation = enableResignation;
    }

    public String getLastEducation() {
        return lastEducation;
    }

    public void setLastEducation(String lastEducation) {
        this.lastEducation = lastEducation;
    }

    public ActiveEnum getHasAccount() {
        return hasAccount;
    }

    public void setHasAccount(ActiveEnum hasAccount) {
        this.hasAccount = hasAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
