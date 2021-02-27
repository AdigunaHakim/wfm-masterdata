package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.TaskType;
import id.co.asyst.wfm.master.repository.rules.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskTypeServiceImpl extends BaseServiceManager<TaskType, String> implements TaskTypeService<TaskType, String>{

    @Autowired
    TaskTypeRepository taskTypeRepository;

    @Override
    public Collection<TaskType> findAll() {
        return (Collection<TaskType>) taskTypeRepository.findAll();
    }

    @Override
    public TaskType findById(String s) {
        return taskTypeRepository.findById(s).get();
    }

    @Override
    public TaskType saveOrUpdate(TaskType taskType) {
        return taskTypeRepository.save(taskType);
    }

    @Override
    public void deleteById(String s) {
        taskTypeRepository.deleteById(s);
    }

    @Override
    public void delete(TaskType taskType) {
        taskTypeRepository.delete(taskType);
    }
}
