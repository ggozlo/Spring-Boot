package com.example.demo.repository;

import com.example.demo.domain.PostDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PostRepository  {

    private final EntityManager entityManager;

    public void postSave(PostDomain postDomain) {
        entityManager.persist(postDomain);
    }

    public PostDomain postFind(Long id) {
        return entityManager.find(PostDomain.class, id);
    }


}
