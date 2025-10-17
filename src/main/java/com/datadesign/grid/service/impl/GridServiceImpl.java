package com.datadesign.treegrid.service.impl;

import com.datadesign.treegrid.model.TGGrid;
import com.datadesign.treegrid.repository.TGGridRepository;
import com.datadesign.treegrid.service.TGGridService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TGGridServiceImpl implements TGGridService {

    private final TGGridRepository repository;

    public TGGridServiceImpl(TGGridRepository repository) {
        this.repository = repository;
    }

    @Override
    public TGGrid save(TGGrid grid) {
        return repository.save(grid);
    }

    @Override
    public Optional<TGGrid> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TGGrid> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

