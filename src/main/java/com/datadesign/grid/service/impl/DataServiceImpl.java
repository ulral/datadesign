package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.Data;
import com.datadesign.grid.repository.DataRepository;
import com.datadesign.grid.service.TGDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TGDataServiceImpl implements TGDataService {

    private final DataRepository repository;

    public TGDataServiceImpl(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Data save(Data data) {
        return repository.save(data);
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

}

