package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.TaskRuleDetail;
import id.co.asyst.wfm.master.repository.rules.TaskRuleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskRuleDetailServiceImpl extends BaseServiceManager<TaskRuleDetail, Long> implements TaskRuleDetailService<TaskRuleDetail, Long>{

    @Autowired
    TaskRuleDetailRepository taskRuleDetailRepository;

    @Override
    public Collection<TaskRuleDetail> findAll() {
        return (Collection<TaskRuleDetail>) taskRuleDetailRepository.findAll();
    }

    @Override
    public TaskRuleDetail findById(Long s) {
        return taskRuleDetailRepository.findById(s).get();
    }

    @Override
    public TaskRuleDetail saveOrUpdate(TaskRuleDetail taskRuleDetail) {
        return taskRuleDetailRepository.save(taskRuleDetail);
    }

    @Override
    public void deleteById(Long s) {
        taskRuleDetailRepository.deleteById(s);
    }

    @Override
    public void delete(TaskRuleDetail taskRuleDetail) {
        taskRuleDetailRepository.delete(taskRuleDetail);
    }
}
