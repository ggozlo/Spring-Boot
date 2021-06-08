package com.example.test.controller;

import com.example.test.domain.Member;
import com.example.test.dto.MemberDto;
import com.example.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

    @GetMapping("/member") // 입력폼
    public String form(@ModelAttribute("member")MemberDto dto) {
        return "inputForm";
    }

    @PostMapping("/member") // 입력
    public String member(MemberDto dto) {
        Member member = MemberDto.doDomain(dto);
        service.save(member);
        return "redirect:/member/list";
    }

    @GetMapping("/member/list") // 전체출력
    public String list(Model model) {
        List<Member> list =  service.findAll();
        List<MemberDto> collect = list.stream().map(MemberDto::doDto).collect(Collectors.toList());
        model.addAttribute("list", collect);
        return "list";
    }

    @GetMapping("/member/update/{id}") // 수정폼
    public String updateForm(Model model, @PathVariable("id") Long id) {
        Member member = service.find(id);
        MemberDto dto = MemberDto.doDto(member);
        model.addAttribute("member", dto);
        return "inputForm";
    }

    @PostMapping("/member/update") // 수정
    public String update(MemberDto dto) {
        service.update(dto);
        return "redirect:/member/list";
    }

    @GetMapping("/member/delete/{id}") // 삭제
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/member/list";
    }

    @GetMapping("/member/search")
    public String search(String name, Model model) {
        List<Member> list =  service.nameSearch(name);
        List<MemberDto> collect = list.stream().map(MemberDto::doDto).collect(Collectors.toList());
        model.addAttribute("list", collect);
        return "list";
    }

}
