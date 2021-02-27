package id.co.asyst.wfm.master.service.rule;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.master.model.rules.Color;
import id.co.asyst.wfm.master.repository.rules.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ColorServiceImpl extends BaseServiceManager<Color, String> implements ColorService<Color, String>{

    @Autowired
    ColorRepository colorRepository;

    @Override
    public Collection<Color> findAll() {
        return (Collection<Color>) colorRepository.findAll();
    }

    @Override
    public Color findById(String s) {
        return colorRepository.findById(s).get();
    }

    @Override
    public Color saveOrUpdate(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void deleteById(String s) {
        colorRepository.deleteById(s);
    }

    @Override
    public void delete(Color color) {
        colorRepository.delete(color);
    }
}
