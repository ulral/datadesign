package com.datadesign.grid.model;

import com.datadesign.treegrid.model.TGUploadData;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TG_DATA_ATTR_ITEM", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ATTR_SN", "ATTR_ROW", "ATTR_ITEM"})
})
public class TGDataAttrItem extends TGUploadData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN")
    @JsonProperty("SN")
    private Long sn;

    @ManyToOne
    @JoinColumn(name = "ATTR_SN") // DB 컬럼명도 변경 시 반영
    @JsonProperty("ATTR_SN")
    private DataAttr attrSn;

    @Column(name = "ATTR_ROW")
    @JsonProperty("ATTR_ROW")
    private int attrRow;

    @Column(name = "ATTR_ITEM")
    @JsonProperty("ATTR_ITEM")
    private String attrItem;

    @Column(name = "ATTR_VALUE")
    @JsonProperty("ATTR_VALUE")
    private String attrValue;

    @Column(name = "USE_YN")
    @JsonProperty("USE_YN")
    private char useYn;

}