package id.co.asyst.wfm.master.repository.schedule;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.master.model.schedule.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends BaseJpaRepository<TaskStatus, Long> {
}
