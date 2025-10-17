package com.datadesign.treegrid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TG_DATA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SN", "DATA"})
})
public class TGData extends TGUploadData {
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