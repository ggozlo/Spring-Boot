package com.ggozlo.crud.service;

import com.ggozlo.crud.Entity.School;
import com.ggozlo.crud.dto.SchoolDto;
import com.ggozlo.crud.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;

    @Transactional
    public SchoolDto save(SchoolDto dto) {
        repository.save(SchoolDto.toDomain(dto));
        return SchoolDto.toDto(repository.select(dto.getId()));
    }

    @Transactional(readOnly = true)
    public List<SchoolDto> findAll() {
        List<SchoolDto> list = new ArrayList<>();

        List<School> schools = repository.selectAll();
        for (School school : schools) {
            list.add(SchoolDto.toDto(school));
        }
        return list;
    }

    @Transactional(readOnly = true)
    public SchoolDto findOne(Long id) {
        try {
            return SchoolDto.toDto(repository.select(id));
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Transactional
    public SchoolDto modify(SchoolDto dto) {
        School selectSchool = repository.select(dto.getId());
        selectSchool.setName(dto.getName());
        selectSchool.setTel(dto.getTel());
        return SchoolDto.toDto(repository.select(dto.getId()));
    }

    // 아이디로 삭제
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    // 이름으로 삭제
    @Transactional
    public void nameDelete(String name) {
        repository.nameDelete(name);
    }

    // 다중조건 삭제
    @Transactional
    public void schoolDelete(Long id, String name) {
        repository.deleteIdName(id, name);

    }
}
