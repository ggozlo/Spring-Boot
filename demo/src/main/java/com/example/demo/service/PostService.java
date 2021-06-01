package com.example.demo.service;

import com.example.demo.domain.PostDomain;
import com.example.demo.dto.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    private Repository repository1;

    @Transactional
    public Long postSave(Post post) {
        PostDomain domain = Post.postToDomain(post);
        repository.postSave(domain);
        return domain.getId();
    }

    @Transactional(readOnly = true)
    public Post postFind(Long id) {
        return Post.domainToPost(repository.postFind(id));
    }
}
