package com.lashwanth.quiz.service;

import com.lashwanth.quiz.dao.QuestionDao;
import com.lashwanth.quiz.dao.QuizDao;
import com.lashwanth.quiz.model.Question;
import com.lashwanth.quiz.model.QuestionWrapper;
import com.lashwanth.quiz.model.Quiz;
import com.lashwanth.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String name, int num) {
        List<Question> questions = questionDao.findQuestions(num);
        Quiz quiz = new Quiz();
        quiz.setName(name);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsUser = new ArrayList<>();
        for(Question q : questionDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsUser.add(qw);
        }

        return new ResponseEntity<>(questionsUser, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionDB = quiz.get().getQuestions();
        Boolean result = null;
        int i = 0;
        for(Response r : responses) {
            if(r.getResponse().equalsIgnoreCase(questionDB.get(i).getAnswer())) {
                result = true;
            } else {
                result = false;
            }
            i++;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
