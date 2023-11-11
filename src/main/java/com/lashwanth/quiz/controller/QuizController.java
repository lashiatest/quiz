package com.lashwanth.quiz.controller;

import com.lashwanth.quiz.model.QuestionWrapper;
import com.lashwanth.quiz.model.Response;
import com.lashwanth.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Boolean> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String name, @RequestParam int num) {
        return quizService.createQuiz(name, num);
    }
}
