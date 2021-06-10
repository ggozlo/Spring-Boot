package com.ggozlo.score.controller;


import com.ggozlo.score.dto.ProductDto;
import com.ggozlo.score.dto.ScoreDto;
import com.ggozlo.score.service.ProductService;
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
public class ProductController {
    private final ProductService service;

    @GetMapping("product")
    public String form(@ModelAttribute("product") ProductDto dto) {
        return "product/form";
    }

    @PostMapping("product")
    public String score(@Valid @ModelAttribute("product") ProductDto dto, BindingResult result) {
        if(result.hasErrors()) {
            return "product/form";
        }
        service.saveOne(dto);
        return "redirect:/product/list";
    }

    @GetMapping("product/list")
    public String list(Model model) {
        model.addAttribute("list", service.findAll() );
        return "product/list";
    }

    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.removeOne(id);
        return "redirect:/product/list";
    }

    @GetMapping("product/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", service.findOne(id));
        return "product/updateForm";
    }

    @PostMapping("product/update")
    public String update(ProductDto dto) {
        service.updateOne(dto);
        return "redirect:/product/list";
    }

    @PostMapping("product/search")
    public String search(String name, Model model) {
        System.out.println("name = " + name);
        model.addAttribute("list", service.findAllName(name));
        return "product/list";
    }

    @GetMapping("product/summary")
    public String summary(Model model) {
        model.addAttribute("list", service.profitMap());
        return "product/summary";
    }
}
