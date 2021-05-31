package com.example.demo2.controller;

import com.example.demo2.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("hello", "Hello InteliJ!");
        return "home";
    }

    @GetMapping("/hello")
    public String form(@ModelAttribute("member") Member member) {
        return "form";
    }

    @PostMapping("/hello")
    public String hello(Model model, Member member) {
        model.addAttribute("member", member);

        return "hello";
    }


}
