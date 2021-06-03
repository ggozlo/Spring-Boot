package com.ggozlo.crud2.repository;

import com.ggozlo.crud2.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    public List<School> findByNameContaining(String name);
}
