package id.co.asyst.wfm.master.service.schedule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.schedule.TaskStatus;
import id.co.asyst.wfm.master.repository.schedule.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskStatusServiceImpl extends BaseServiceManager<TaskStatus, Long> implements TaskStatusService<TaskStatus, Long> {

    @Autowired
    TaskStatusRepository taskStatusRepository;

    @Override
    public Collection<TaskStatus> findAll() {
        return (Collection<TaskStatus>) taskStatusRepository.findAll();
    }

    @Override
    public TaskStatus findById(Long aLong) {
        return taskStatusRepository.findById(aLong).get();
    }

    @Override
    public TaskStatus saveOrUpdate(TaskStatus taskStatus) {
        return taskStatusRepository.save(taskStatus);
    }

    @Override
    public void deleteById(Long aLong) {
        taskStatusRepository.deleteById(aLong);
    }

    @Override
    public void delete(TaskStatus taskStatus) {
        taskStatusRepository.delete(taskStatus);
    }
}
