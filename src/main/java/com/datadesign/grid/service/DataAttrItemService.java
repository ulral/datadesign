package com.datadesign.grid.service;

import com.datadesign.grid.model.DataAttrItem;

import java.util.List;
import java.util.Optional;

public interface TGDataAttrItemService {
    DataAttrItem save(DataAttrItem attr);
    Optional<DataAttrItem> findById(Long id);
    List<DataAttrItem> findAll();
    void deleteById(Long id);
    List<DataAttrItem> findDataLayoutRaw(String dataName);
}
