package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.TaskRule;
import id.co.asyst.wfm.master.repository.rules.TaskRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskRuleServiceImpl extends BaseServiceManager<TaskRule, String> implements TaskRuleService<TaskRule, String>{

    @Autowired
    TaskRuleRepository taskRuleRepository;

    @Override
    public Collection<TaskRule> findAll() {
        return (Collection<TaskRule>) taskRuleRepository.findAll();
    }

    @Override
    public TaskRule findById(String s) {
        return taskRuleRepository.findById(s).get();
    }

    @Override
    public TaskRule saveOrUpdate(TaskRule taskRule) {
        return taskRuleRepository.save(taskRule);
    }

    @Override
    public void deleteById(String s) {
        taskRuleRepository.deleteById(s);
    }

    @Override
    public void delete(TaskRule taskRule) {
        taskRuleRepository.delete(taskRule);
    }
}
