package com.datadesign.grid.model;

import com.datadesign.treegrid.model.TGUploadData;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@lombok.Data
@Entity
@Table(name = "TG_DATA_ATTR", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SN", "ATTR"})
})
public class DataAttr extends TGUploadData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN")
    @JsonProperty("SN")
    private Long sn;

    @ManyToOne
    @JoinColumn(name = "DATA_SN")
    @JsonProperty("DATA_SN")
    private Data dataSn;

    @Column(name = "ATTR")
    @JsonProperty("ATTR")
    private String attr;

    @Column(name = "USE_YN")
    @JsonProperty("USE_YN")
    private char useYn;

}