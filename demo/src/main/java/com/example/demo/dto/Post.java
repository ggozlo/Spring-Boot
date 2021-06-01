package com.example.demo.dto;

import com.example.demo.domain.PostDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class Post {

    private Long id;

    private String title;

    private String content;

    public static Post domainToPost(PostDomain domain) {
        Post post = new Post();
        post.setTitle(domain.getTitle());
        post.setContent(domain.getContent());
        return post;
    }

    public static PostDomain postToDomain(Post post) {
        PostDomain domain = new PostDomain();
        domain.setTitle(post.getTitle());
        domain.setContent(post.getContent());
        return domain;
    }
}
