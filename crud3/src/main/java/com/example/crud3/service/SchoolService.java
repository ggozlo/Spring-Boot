package com.example.crud3.service;

import com.example.crud3.domain.Member;
import com.example.crud3.dto.MemberDto;
import com.example.crud3.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;

    @Transactional
    public void addOne(MemberDto dto) {
        repository.save(MemberDto.toDomain(dto));
    }
    @Transactional
    public List<MemberDto> listAll() {
        return repository.findAll().stream().map(MemberDto::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }
    @Transactional
    public MemberDto findOne(Long id) {
        return MemberDto.toDto(repository.findById(id).get());
    }


    @Transactional
    public void updateOne(MemberDto dto) {
        Member targetSchool = repository.findById(dto.getId()).get();
        targetSchool.setName(dto.getName());
        targetSchool.setTel(dto.getTel());
        repository.save(targetSchool);
    }

    @Transactional
    public List<MemberDto> nameSearch(String name) {
        return repository.findByNameContaining(name).stream().map(MemberDto:: toDto).collect(Collectors.toList());
    }
}
