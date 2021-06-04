package com.ggozlo.crud2.controller;

import com.ggozlo.crud2.dto.SchoolDto;
import com.ggozlo.crud2.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    // 입력창 반환
    @GetMapping("school")
    public String form(Model model) {
        model.addAttribute("school", new SchoolDto());
        return "form";
    }

    // 전체 리스트 반환
    @GetMapping("school/list")
    public String list(Model model, String name) {
        System.out.println(name);
        model.addAttribute("list", service.listAll());
        return "list";
    }

    // 입력 값 추가
    @PostMapping("school")
    public String addSchool(@ModelAttribute("school") @Valid SchoolDto schoolDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "form";
        }
        service.addOne(schoolDto);
        return "redirect:/school/list";
    }

    // 단일 대상 삭제
    @GetMapping("school/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteOne(id);
        return "redirect:/school/list";
    }

    // 단일 대상 수정페이지
    @GetMapping("school/update/{id}")
    public String modifyForm(Model model, @PathVariable("id")Long id) {
        model.addAttribute("school", service.findOne(id));
        return "modifyForm";
    }

    //  단일 대장 수정
    @PostMapping("school/update")
    public String update(SchoolDto dto) {
        service.updateOne(dto);
        return "redirect:/school/list";
    }

    // 이름 검색색    @PostMapping("school/search")
    public String nameSearch(String name, Model model) {
        model.addAttribute("list", service.nameSearch(name));
        return "list";
    }

}
