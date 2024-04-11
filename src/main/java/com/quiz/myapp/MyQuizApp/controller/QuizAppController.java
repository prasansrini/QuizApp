package com.quiz.myapp.MyQuizApp.controller;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;
import com.quiz.myapp.MyQuizApp.service.QuizAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizAppController {

    @Autowired
    private QuizAppService quizAppService;

    @GetMapping("/questions")
    public List<QuizQuestionWrapper> getQuizQuestions() {
        return quizAppService.getQuizQuestions();
    }

    @PostMapping("/create")
    public String[] addDefaultEntries() {
        quizAppService.putDefaultEntries();

        return new String[]{"status:200", "message:success"};
    }

        @GetMapping("/question/next")
    public QuizQuestionWrapper getNextQuestion() {
        return quizAppService.nextQuestion();
    }
}
