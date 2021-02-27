package id.co.asyst.wfm.master.repository.rules;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.rules.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends BaseJpaRepository<Location, String> {
}
