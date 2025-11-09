package com.datadesign.grid.service;

import com.datadesign.grid.model.GridAttrItem;

import java.util.List;

public interface GridAttrItemService {
    List<GridAttrItem> findGridLayoutRaw(String dataName);
}
