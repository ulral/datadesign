package com.datadesign.sample.service.impl;

import com.datadesign.sample.model.Member;
import com.datadesign.sample.repository.SampleMemberRepository;
import com.datadesign.sample.service.SampleMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class SampleMemberServiceImpl implements SampleMemberService {

    private final SampleMemberRepository sampleMemberRepository;

    @Override
    public Member save(Member member) {
        return sampleMemberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return sampleMemberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return sampleMemberRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        sampleMemberRepository.deleteById(id);
    }

}
