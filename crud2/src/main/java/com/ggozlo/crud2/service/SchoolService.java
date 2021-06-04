package com.ggozlo.crud2.service;

import com.ggozlo.crud2.domain.School;
import com.ggozlo.crud2.dto.SchoolDto;
import com.ggozlo.crud2.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;

    // 단일 저장
    @Transactional
    public void addOne(SchoolDto dto) {
        repository.save(SchoolDto.toDomain(dto));
    }

    // 전체 조회
    @Transactional
    public List<SchoolDto> listAll() {
        return repository.findAll().stream().map(SchoolDto::toDto).collect(Collectors.toList());
    }

    // 단일 조회
    @Transactional
    public SchoolDto findOne(Long id) {
        return SchoolDto.toDto(repository.findById(id).get());
    }

    // 단일 삭제
    @Transactional
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }

    // 단일 수정
    @Transactional
    public void updateOne(SchoolDto dto) {
        School targetSchool = repository.findById(dto.getId()).get();
        targetSchool.setName(dto.getName());
        targetSchool.setTel(dto.getTel());
    }

    // 이름 전체 검색
    @Transactional
    public List<SchoolDto> nameSearch(String name) {
        return repository.findByNameContaining(name).stream().map(SchoolDto :: toDto).collect(Collectors.toList());
    }
}
