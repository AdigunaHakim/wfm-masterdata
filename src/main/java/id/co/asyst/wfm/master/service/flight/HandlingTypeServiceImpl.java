package id.co.asyst.wfm.master.service.flight;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.flight.HandlingType;
import id.co.asyst.wfm.master.repository.flight.HandlingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class HandlingTypeServiceImpl extends BaseServiceManager<HandlingType, String> implements HandlingTypeService<HandlingType, String> {

    @Autowired
    HandlingTypeRepository handlingTypeRepository;

    @Override
    public Collection<HandlingType> findAll() {
        return (Collection<HandlingType>) handlingTypeRepository.findAll();
    }

    @Override
    public HandlingType findById(String s) {
        return handlingTypeRepository.findById(s).get();
    }

    @Override
    public HandlingType saveOrUpdate(HandlingType handlingType) {
        return handlingTypeRepository.save(handlingType);
    }

    @Override
    public void deleteById(String s) {
        handlingTypeRepository.deleteById(s);
    }

    @Override
    public void delete(HandlingType handlingType) {
        handlingTypeRepository.delete(handlingType);
    }

    @Override
    public List<HandlingType> findByHandlingTypeCodeList(String handlingTypeCode) {
        return handlingTypeRepository.findByHandlingTypeCodeContains(handlingTypeCode);
    }

    @Override
    public Page<HandlingType> findByHandlingTypeCodePage(String handlingTypeCode, Pageable pageable) {
        return handlingTypeRepository.findByHandlingTypeCodeContains(handlingTypeCode, pageable);
    }

    @Override
    public Integer countById(String id) {
        return handlingTypeRepository.countByHandlingTypeCode(id);
    }
}
