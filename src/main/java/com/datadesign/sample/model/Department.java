package com.datadesign.sample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Member> members;
}

