package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.GridAttr;
import com.datadesign.grid.repository.GridAttrRepository;
import com.datadesign.treegrid.service.TGService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GridAttrServiceImpl implements TGService<GridAttr> {

    private final GridAttrRepository repository;

    public GridAttrServiceImpl(GridAttrRepository repository) {
        this.repository = repository;
    }

    @Override
    public GridAttr save(GridAttr entity) {
        return repository.save(entity);
    }

    @Override
    public List<GridAttr> saveAll(List<GridAttr> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<GridAttr> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<GridAttr> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Class<GridAttr> getTargetType() {
        return GridAttr.class;
    }

}

