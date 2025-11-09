package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.Data;
import com.datadesign.grid.repository.DataRepository;
import com.datadesign.treegrid.service.TGService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements TGService<Data> {

    private final DataRepository repository;

    public DataServiceImpl(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Data save(Data data) {
        return repository.save(data);
    }

    @Override
    public List<Data> saveAll(List<Data> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<Data> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Data> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Class<Data> getTargetType() {
        return Data.class;
    }

}

