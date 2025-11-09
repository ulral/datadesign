package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.GridAttrItem;
import com.datadesign.grid.repository.GridAttrItemRepository;
import com.datadesign.grid.service.GridAttrItemService;
import com.datadesign.treegrid.service.TGService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GridAttrItemServiceImpl implements TGService<GridAttrItem>, GridAttrItemService {

    private final GridAttrItemRepository repository;

    public GridAttrItemServiceImpl(GridAttrItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public GridAttrItem save(GridAttrItem entity) {
        return repository.save(entity);
    }

    @Override
    public List<GridAttrItem> saveAll(List<GridAttrItem> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<GridAttrItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<GridAttrItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Class<GridAttrItem> getTargetType() {
        return GridAttrItem.class;
    }

    public  List<GridAttrItem> findGridLayoutRaw(String dataName){
        return repository.findGridLayoutRaw(dataName);
    };

}

