package com.datadesign.grid.service;

import com.datadesign.grid.model.GridAttrItem;

import java.util.List;
import java.util.Optional;

public interface TGGridAttrItemService {
    GridAttrItem save(GridAttrItem attr);
    Optional<GridAttrItem> findById(Long id);
    List<GridAttrItem> findAll();
    void deleteById(Long id);
    List<GridAttrItem> findGridLayoutRaw(String dataName);
}
