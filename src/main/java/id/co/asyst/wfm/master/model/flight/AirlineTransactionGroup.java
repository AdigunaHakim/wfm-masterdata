package id.co.asyst.wfm.master.model.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import id.co.asyst.wfm.master.model.ActiveEnum;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "AIRLINE_TRANSACTION_GROUP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class AirlineTransactionGroup extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "AIRLINE_CODE", nullable = false)
    private Airline airline;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "AIRLINE_GROUP_CODE", nullable = false)
    private AirlineGroup airlineGroup;

    @Column(name = "ACTIVE")
    private ActiveEnum active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public AirlineGroup getAirlineGroup() {
        return airlineGroup;
    }

    public void setAirlineGroup(AirlineGroup airlineGroup) {
        this.airlineGroup = airlineGroup;
    }

    public ActiveEnum getActive() {
        return active;
    }

    public void setActive(ActiveEnum active) {
        this.active = active;
    }
}
