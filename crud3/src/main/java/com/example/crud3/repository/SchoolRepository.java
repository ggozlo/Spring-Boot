package com.example.crud3.repository;

import com.example.crud3.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<Member, Long> {

    public List<Member> findByNameContaining(String name);
}
