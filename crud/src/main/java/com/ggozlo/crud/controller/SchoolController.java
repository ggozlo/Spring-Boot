package com.ggozlo.crud.controller;

import com.ggozlo.crud.dto.SchoolDto;
import com.ggozlo.crud.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    //전체 리스트
    @GetMapping("school/list")
    @ResponseBody
    public List<SchoolDto> list() {
        return service.findAll();
    }

    //단일 대상
    @GetMapping("school")
    @ResponseBody
    public Optional<SchoolDto> select(Long id) {
        return Optional.ofNullable(service.findOne(id));
    }

    // 단일 입력
    @PostMapping("school")
    @ResponseBody
    public SchoolDto school(SchoolDto dto, Model model) {
        return  service.save(dto);
    }

    // 아이디 단일 수정
    @PutMapping("school")
    @ResponseBody
    public SchoolDto schoolModify(SchoolDto dto) {
        return service.modify(dto);
    }

    // 이름 전체 삭제
    @PutMapping("school/name")
    public String schoolDelete(String name) {
        service.nameDelete(name);
        return "redirect:school/list";
    }

    // 아이디 대상 삭제
    @DeleteMapping("school")
    public String schoolDelete(Long id) {
        service.delete(id);
        return "redirect:school/list";
    }

    // 아이디 대상 삭제
    @DeleteMapping("school/delete")
    public String delete(Long id, String name) {
        service.schoolDelete(id,name);
        return "redirect:school/list";
    }
}
