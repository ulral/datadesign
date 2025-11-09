package com.datadesign.sample.service;

import com.datadesign.sample.model.Member;

import java.util.List;
import java.util.Optional;

public interface SampleMemberService {
    Member save(Member member);
    Optional<Member> findById(Long id);
    List<Member> findAll();
    void delete(Long id);
}
