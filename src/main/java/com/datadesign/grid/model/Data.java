package com.datadesign.grid.model;

import com.datadesign.treegrid.model.TGUploadData;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@lombok.Data
@Entity
@Table(name = "TG_DATA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SN", "DATA"})
})
public class Data extends TGUploadData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN")
    @JsonProperty("SN")
    private Long sn;

    @Column(name = "DATA")
    @JsonProperty("DATA")
    private String data;

    @Column(name = "NAME")
    @JsonProperty("NAME")
    private String name;

    @Column(name = "USE_YN")
    @JsonProperty("USE_YN")
    private char useYn;
}