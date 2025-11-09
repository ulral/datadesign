package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.Grid;
import com.datadesign.grid.repository.GridRepository;
import com.datadesign.treegrid.service.TGService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GridServiceImpl implements TGService<Grid> {

    private final GridRepository repository;

    public GridServiceImpl(GridRepository repository) {
        this.repository = repository;
    }

    @Override
    public Grid save(Grid grid) {
        return repository.save(grid);
    }

    @Override
    public List<Grid> saveAll(List<Grid> grids) {
        return repository.saveAll(grids);
    }
    @Override
    public Optional<Grid> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Grid> findAll() {
        return repository.findAll();
    }

    @Override
    public Class<Grid> getTargetType() {
        return Grid.class;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

