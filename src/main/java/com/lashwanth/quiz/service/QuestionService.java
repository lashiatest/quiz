package com.lashwanth.quiz.service;

import com.lashwanth.quiz.Question;
import com.lashwanth.quiz.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getQuestions() {
        return questionDao.findAll();
    }

    public Optional<Question> getQuestionsById(Integer id){
        return questionDao.findById(id);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "added";
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "deleted";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "updated";
    }
}
