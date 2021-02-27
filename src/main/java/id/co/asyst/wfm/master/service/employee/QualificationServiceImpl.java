package id.co.asyst.wfm.master.service.employee;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.ActiveEnum;
import id.co.asyst.wfm.master.model.employee.Qualification;
import id.co.asyst.wfm.master.repository.employee.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class QualificationServiceImpl extends BaseServiceManager<Qualification, String> implements QualificationService<Qualification,String> {


    @Autowired
    QualificationRepository qualificationRepository;

    @Override
    public Collection<Qualification> findAll() {
        return (Collection<Qualification>) qualificationRepository.findAll();
    }

    @Override
    public Qualification findById(String code) {
        return qualificationRepository.findById(code).get();
    }

    @Override
    public Qualification saveOrUpdate(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    @Override
    public void deleteById(String code) {
        qualificationRepository.deleteById(code);
    }

    @Override
    public void delete(Qualification qualification) {
        qualificationRepository.delete(qualification);
    }

    @Override
    public Page<Qualification> findByQualificationCode(String qualificationCode, ActiveEnum active, Pageable pageable) {
        return qualificationRepository.findByQualificationCodeContainsAndActive(qualificationCode, active, pageable);
    }

    @Override
    public List<Qualification> findByQualifiationCodeIs(String qualificationCode, ActiveEnum active) {
        return qualificationRepository.findByQualificationCodeContainsAndActive(qualificationCode, active);
    }

    @Override
    public Integer countByQualificationCode(String qualificationCode) {
        return qualificationRepository.countByQualificationCode(qualificationCode);
    }
}
