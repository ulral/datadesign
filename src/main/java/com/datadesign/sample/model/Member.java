package com.datadesign.sample.model;

import com.datadesign.treegrid.model.TGUploadData;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEMBER")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member extends TGUploadData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false)
    @JsonProperty("ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    @JsonProperty("NAME")
    private String name;
    @Column(name = "AGE", nullable = false)
    @JsonProperty("AGE")
    private String age;
    @Column(name = "EMAIL", nullable = false)
    @JsonProperty("EMAIL")
    private String email;
    @Column(name = "PHONE", nullable = false)
    @JsonProperty("PHONE")
    private String phone;
    @Column(name = "DEPARTMENT", nullable = false)
    @JsonProperty("DEPARTMENT")
    private String department;
    @Column(name = "POSITION", nullable = false)
    @JsonProperty("POSITION")
    private String position;
}
