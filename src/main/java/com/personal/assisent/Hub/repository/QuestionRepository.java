package com.personal.assisent.Hub.repository;

import com.personal.assisent.Hub.entity.postgres.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    String TABLE_NAME = "leetcode.questions";

    @Modifying
    @Query(value = "TRUNCATE " + TABLE_NAME + " CASCADE", nativeQuery = true)
    void deleteAll();

}
