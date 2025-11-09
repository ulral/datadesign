package com.datadesign.sample.repository;

import com.datadesign.sample.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleMemberRepository extends JpaRepository<Member, Long> {
}
