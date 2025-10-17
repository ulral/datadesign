package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.GridAttrItem;
import com.datadesign.grid.repository.GridAttrItemRepository;
import com.datadesign.grid.service.TGGridAttrItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TGGridAttrItemServiceImpl implements TGGridAttrItemService {

    private final GridAttrItemRepository repository;

    public TGGridAttrItemServiceImpl(GridAttrItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public GridAttrItem save(GridAttrItem grid) {
        return repository.save(grid);
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
    public  List<GridAttrItem> findGridLayoutRaw(String dataName){
        return repository.findGridLayoutRaw(dataName);
    };

}

