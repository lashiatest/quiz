package com.lashwanth.quiz.dao;

import com.lashwanth.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT * FROM questions q ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Question> findQuestions(int num);
}
