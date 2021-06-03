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

    @GetMapping("school")
    public String form(Model model) {
        model.addAttribute("school", new SchoolDto());
        return "form";
    }

    @GetMapping("school/list")
    public String list(Model model, String name) {
        System.out.println(name);
        model.addAttribute("list", service.listAll());
        return "list";
    }

    @PostMapping("school")
    public String addSchool(@ModelAttribute("school") @Valid SchoolDto schoolDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "form";
        }
        service.addOne(schoolDto);
        return "redirect:/school/list";
    }

    @GetMapping("school/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteOne(id);
        return "redirect:/school/list";
    }

    @GetMapping("school/update/{id}")
    public String modifyForm(Model model, @PathVariable("id")Long id) {
        model.addAttribute("school", service.findOne(id));
        return "modifyForm";
    }

    @PostMapping("school/update")
    public String update(SchoolDto dto) {
        service.updateOne(dto);
        return "redirect:/school/list";
    }

    @PostMapping("school/search")
    public String nameSearch(String name, Model model) {
        model.addAttribute("list", service.nameSearch(name));
        return "list";
    }

}
