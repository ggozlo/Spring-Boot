package com.ggozlo.crud.repository;

import com.ggozlo.crud.Entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScRepository extends CrudRepository<School, Long> {
}
