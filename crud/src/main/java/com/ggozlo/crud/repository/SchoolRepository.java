package com.ggozlo.crud.repository;

import com.ggozlo.crud.Entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SchoolRepository {

    private final EntityManager entityManager;

    //저장
    public void save(School school) {
        entityManager.persist(school);
    }

    //삭제
    public void delete(Long id) {
        School targetSchool = entityManager.find(School.class, id);
        entityManager.remove(targetSchool);
    }

    // 이름 삭제
   public void nameDelete(String name) {
        entityManager.createQuery("delete FROM School  WHERE name = :name").setParameter("name", name).executeUpdate();
    }

    //탐색
    public School select(Long id) {
        return entityManager.find(School.class, id);
    }

    // 전체 선택
    public List<School> selectAll() {
        return entityManager.createQuery("select s from School s").getResultList();
    }


    // 이름 아이디 삭제
    public void deleteIdName(Long id, String name) {
        entityManager.createQuery("delete FROM School s WHERE s.name = :name AND s.id = :id")
                .setParameter("name", name).setParameter("id", id).executeUpdate();
    }
}
