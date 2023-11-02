package com.lashwanth.quiz.controller;

import com.lashwanth.quiz.Question;
import com.lashwanth.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("questions")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("id/{id}")
    public Optional<Question> getQuestionsById(@PathVariable Integer id) {
        return questionService.getQuestionsById(id);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Integer id) {
        return questionService.deleteQuestion(id);
    }

    @PutMapping("update")
    public String updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }
}
