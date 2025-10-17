package com.datadesign.treegrid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TG_DATA_ATTR", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SN", "ATTR"})
})
public class TGDataAttr extends TGUploadData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN")
    @JsonProperty("SN")
    private Long sn;

    @ManyToOne
    @JoinColumn(name = "DATA_SN")
    @JsonProperty("DATA_SN")
    private TGData dataSn;

    @Column(name = "ATTR")
    @JsonProperty("ATTR")
    private String attr;

    @Column(name = "USE_YN")
    @JsonProperty("USE_YN")
    private char useYn;
}