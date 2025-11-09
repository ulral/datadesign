package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.DataAttr;
import com.datadesign.grid.repository.DataAttrRepository;
import com.datadesign.treegrid.service.TGService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataAttrServiceImpl implements TGService<DataAttr> {

    private final DataAttrRepository repository;

    public DataAttrServiceImpl(DataAttrRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataAttr save(DataAttr grid) {
        return repository.save(grid);
    }

    @Override
    public List<DataAttr> saveAll(List<DataAttr> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<DataAttr> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DataAttr> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Class<DataAttr> getTargetType() {
        return DataAttr.class;
    }
}

