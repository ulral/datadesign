package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.DataAttr;
import com.datadesign.grid.repository.DataAttrRepository;
import com.datadesign.grid.service.TGDataAttrService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TGDataAttrServiceImpl implements TGDataAttrService {

    private final DataAttrRepository repository;

    public TGDataAttrServiceImpl(DataAttrRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataAttr save(DataAttr grid) {
        return repository.save(grid);
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
}

