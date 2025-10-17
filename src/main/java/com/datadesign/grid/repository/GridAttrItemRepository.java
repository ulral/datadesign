package com.datadesign.grid.repository;

import com.datadesign.grid.model.GridAttrItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TGGridAttrItemRepository extends JpaRepository<GridAttrItem, Long> {
    @Query(value = """
            SELECT ITEM.SN, ATTR.SN AS ATTR_SN, ATTR.ATTR, ITEM.ATTR_ITEM, ITEM.ATTR_VALUE, ITEM.USE_YN
            FROM TG_GRID GRID
            INNER JOIN TG_GRID_ATTR ATTR ON GRID.SN = ATTR.GRID_SN
            INNER JOIN TG_GRID_ATTR_ITEM ITEM ON ATTR.SN = ITEM.ATTR_SN
            WHERE GRID.GRID = :gridName
            AND GRID.USE_YN = 'Y'
            AND ATTR.USE_YN = 'Y'
            AND ITEM.USE_YN = 'Y'
    """, nativeQuery = true)
    List<GridAttrItem> findGridLayoutRaw(@Param("gridName") String dataName);
}
