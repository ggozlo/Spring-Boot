package com.example.test.service;

import com.example.test.domain.Member;
import com.example.test.dto.MemberDto;
import com.example.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository repository;

    public void save(Member member) {
        repository.save(member);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member find(Long id) {
        return repository.findById(id).get();
    }

    public void update(MemberDto dto) {
        Member member = repository.findById(dto.getId()).get();
        member.setName(dto.getName());
        member.setAddress(dto.getAddress());
        member.setTel(dto.getTel());
        member.setName(dto.getName());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Member> nameSearch(String name) {
        return repository.findByNameContaining(name);
    }
}
