package com.datadesign;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "age", nullable = false)
    private String age;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "department_id", nullable = false)
    private String department_id;
    @Column(name = "position_id", nullable = false)
    private String position_id;
}
