package com.datadesign.grid.service.impl;

import com.datadesign.grid.model.DataAttrItem;
import com.datadesign.grid.repository.DataAttrItemRepository;
import com.datadesign.grid.service.DataAttrItemService;
import com.datadesign.treegrid.service.TGService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataAttrItemServiceImpl implements TGService<DataAttrItem>, DataAttrItemService {

    private final DataAttrItemRepository repository;

    public DataAttrItemServiceImpl(DataAttrItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataAttrItem save(DataAttrItem item) {
        return repository.save(item);
    }

    @Override
    public List<DataAttrItem> saveAll(List<DataAttrItem> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<DataAttrItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DataAttrItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Class<DataAttrItem> getTargetType() {
        return DataAttrItem.class;
    }

    @Override
    public List<DataAttrItem> findDataLayoutRaw(String dataName){
        return repository.findDataLayoutRaw(dataName);
    }
}

