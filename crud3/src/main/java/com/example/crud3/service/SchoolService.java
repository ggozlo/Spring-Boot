package com.example.crud3.service;

import com.example.crud3.domain.School;
import com.example.crud3.dto.SchoolDto;
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
    public void addOne(SchoolDto dto) {
        repository.save(SchoolDto.toDomain(dto));
    }
    @Transactional
    public List<SchoolDto> listAll() {
        return repository.findAll().stream().map(SchoolDto::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }
    @Transactional
    public SchoolDto findOne(Long id) {
        return SchoolDto.toDto(repository.findById(id).get());
    }


    @Transactional
    public void updateOne(SchoolDto dto) {
        School targetSchool = repository.findById(dto.getId()).get();
        targetSchool.setName(dto.getName());
        targetSchool.setTel(dto.getTel());
        repository.save(targetSchool);
    }

    @Transactional
    public List<SchoolDto> nameSearch(String name) {
        return repository.findByNameContaining(name).stream().map(SchoolDto :: toDto).collect(Collectors.toList());
    }
}
