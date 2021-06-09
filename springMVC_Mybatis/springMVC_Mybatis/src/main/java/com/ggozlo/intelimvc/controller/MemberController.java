package com.ggozlo.intelimvc.controller;


import com.ggozlo.intelimvc.dto.Member;
import com.ggozlo.intelimvc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository repository;

    @GetMapping("/member")
    public String input(@ModelAttribute("member") Member member) {
        return "input";
    }
    @PostMapping("/member")
    public String member(Member member) {
        repository.saveMember(member);
        return "redirect:member/list";
    }

    @GetMapping("/member/list")
    public String list(Model model) {
        List<Member> members = repository.memberList();
        model.addAttribute("list", members);
        return "list";
    }

    @GetMapping("/member/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteMember(id);
        return "redirect:/member/list";
    }

    @GetMapping("/member/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Member one = repository.findOne(id);
        model.addAttribute("member", one);
        return "modifyForm";
    }

    @PostMapping("/member/update")
    public String modify(Member member) {
        repository.modifyMember(member);
        return "redirect:/member/list";
    }

    @GetMapping("/member/search")
    public String search(String searchName, Model model) {

        List<Member> members = repository.memberNameSearch(searchName);
        model.addAttribute("list", members);
        return "list";
    }

    @GetMapping("/member/list/api")
    public @ResponseBody List<Member> api() {
        List<Member> members = repository.memberList();
        for (Member member : members) {
            System.out.println("member = " + member);
        }
        return members;
    }

}
