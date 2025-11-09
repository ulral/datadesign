package com.datadesign.sample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "POSITION")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Position {

    @Id
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name= "TITLE", nullable = false)
    private String title;

    @OneToMany(mappedBy = "position")
    private List<Member> members;
}
