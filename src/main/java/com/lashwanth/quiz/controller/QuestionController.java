package com.lashwanth.quiz.controller;

import com.lashwanth.quiz.model.Question;
import com.lashwanth.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("questions")
    public ResponseEntity<List<Question>> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Question>> getQuestionsById(@PathVariable Integer id) {
        return questionService.getQuestionsById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Integer id) {
        return questionService.deleteQuestion(id);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }
}
