package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrrController {



    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("username", "홍길동");
        return "user/user";
    }

    @RequestMapping("/bye")
    public String bye(Model model) {
        model.addAttribute("username", "홍길동");
        return "user/bye";
    }
}
