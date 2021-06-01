package com.example.demo.repository;

import com.example.demo.domain.PostDomain;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<PostDomain, Long> {

}
