package com.example.demo.Controller;

import com.example.demo.dto.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public String form(@ModelAttribute("post") Post post) {
        return "post/form";
    }

    @PostMapping("/post")
    public String form(Post post, Model model) {
        Long id = postService.postSave(post);
        System.out.println(id);
        model.addAttribute("post", post);
        return "post/output";
    }

    @GetMapping("/findpost/{postId}")
    public String findPost(@PathVariable("postId") Long id, Model model) {
        model.addAttribute("post", postService.postFind(id));
        return "post/output";
    }
}
