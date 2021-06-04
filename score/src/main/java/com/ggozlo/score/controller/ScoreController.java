package com.ggozlo.score.controller;

import com.ggozlo.score.dto.ScoreDto;
import com.ggozlo.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService service;

    @GetMapping("score")
    public String form(@ModelAttribute("score")ScoreDto dto) {
        return "form";
    }

    @PostMapping("score")
    public String score(@Valid @ModelAttribute("score")ScoreDto dto, BindingResult result) {
        if(result.hasErrors()) {
            return "form";
        }
        service.saveOne(dto);
        return "redirect:/score/list";
    }

    @GetMapping("score/list")
    public String list(Model model) {
        model.addAttribute("list", service.findAll() );
        return "list";
    }

    @GetMapping("score/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.removeOne(id);
        return "redirect:/score/list";
    }

    @GetMapping("score/update/{id}")
   public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("score", service.findOne(id));
        return "updateForm";
    }

    @PostMapping("score/update")
    public String update(ScoreDto dto) {
        service.updateOne(dto);
        return "redirect:/score/list";
    }

    @PostMapping("score/search")
    public String search(String name, Model model) {
        model.addAttribute("list", service.findAllName(name));
        return "list";
    }




}
