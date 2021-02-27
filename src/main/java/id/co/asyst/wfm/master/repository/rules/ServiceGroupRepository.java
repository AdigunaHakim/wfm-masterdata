package id.co.asyst.wfm.master.repository.rules;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.rules.ServiceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceGroupRepository extends BaseJpaRepository<ServiceGroup, String> {
}
