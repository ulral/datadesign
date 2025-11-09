package com.datadesign.grid.repository;

import com.datadesign.grid.model.DataAttrItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataAttrItemRepository extends JpaRepository<DataAttrItem, Long> {
    @Query(value = """
        SELECT ITEM.SN, ATTR.SN AS ATTR_SN, ITEM.ATTR_ROW, ITEM.ATTR_ITEM, ITEM.ATTR_VALUE, ITEM.USE_YN
        FROM TG_DATA DATA
        INNER JOIN TG_DATA_ATTR ATTR ON DATA.SN = ATTR.DATA_SN
        INNER JOIN TG_DATA_ATTR_ITEM ITEM ON ATTR.SN = ITEM.ATTR_SN
        WHERE DATA.DATA = :dataName
        AND DATA.USE_YN = 'Y'
        AND ATTR.USE_YN = 'Y'
        AND ITEM.USE_YN = 'Y'
    """, nativeQuery = true)
    List<DataAttrItem> findDataLayoutRaw(@Param("dataName") String dataName);
}
