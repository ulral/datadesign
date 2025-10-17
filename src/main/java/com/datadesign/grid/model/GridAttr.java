package com.datadesign.grid.model;

import com.datadesign.treegrid.model.TGUploadData;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TG_GRID_ATTR", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SN", "ATTR"})
})
public class TGGridAttr extends TGUploadData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN")
    @JsonProperty("SN")
    private Long sn;

    @ManyToOne
    @JoinColumn(name = "GRID_SN")
    @JsonProperty("GRID_SN")
    private Grid gridSn;

    @Column(name = "ATTR")
    @JsonProperty("ATTR")
    private String attr;

    @Column(name = "USE_YN")
    @JsonProperty("USE_YN")
    private char useYn;
}