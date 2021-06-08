package com.example.crud3.controller;

import com.example.crud3.domain.Phone;
import com.example.crud3.domain.User;
import com.example.crud3.dto.Dto;
import com.example.crud3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public String user(@ModelAttribute("dto")Dto dto) {
        return "user";
    }

    @PostMapping("/user")
    @Transactional
    public String in(Dto dto) {
        User user = new User(dto.getName());

        for (String s : dto.getTel()) {

        }
        userRepository.save(user);
        return "user";
    }

}
