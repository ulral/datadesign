package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.GridAttr;
import com.datadesign.grid.repository.GridAttrRepository;
import com.datadesign.grid.service.TGGridAttrService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TGGridAttrServiceImpl implements TGGridAttrService {

    private final GridAttrRepository repository;

    public TGGridAttrServiceImpl(GridAttrRepository repository) {
        this.repository = repository;
    }

    @Override
    public GridAttr save(GridAttr grid) {
        return repository.save(grid);
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

}

