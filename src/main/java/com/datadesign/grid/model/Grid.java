package com.datadesign.treegrid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TG_GRID")
public class TGGrid extends TGUploadData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN")
    @JsonProperty("SN")
    private Long sn;

    @Column(name = "GRID")
    @JsonProperty("GRID")
    private String grid;

    @Column(name = "NAME")
    @JsonProperty("NAME")
    private String name;

    @Column(name = "USE_YN")
    @JsonProperty("USE_YN")
    private char useYn;

}

