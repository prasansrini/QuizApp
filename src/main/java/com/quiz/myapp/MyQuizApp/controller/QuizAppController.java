package com.quiz.myapp.MyQuizApp.controller;

import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;
import com.quiz.myapp.MyQuizApp.service.QuizAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
public class QuizAppController {

    @Autowired
    private QuizAppService quizAppService;

    @GetMapping("/questions")
    public List<QuizQuestionWrapper> getQuizQuestions() {
        return quizAppService.getQuizQuestions();
    }

    @PostMapping("/questions")
    public String[] addDefaultEntries() {
        quizAppService.putDefaultEntries();

        return new String[]{"status:200", "message:success"};
    }

    @GetMapping("/questions/next")
    public QuizQuestionWrapper getNextQuestion() {
        return quizAppService.nextQuestion();
    }

    @PostMapping("/questions/lifeline")
    public QuizQuestionWrapper getLifeLine(@RequestParam int id) {
        return quizAppService.getLifeLine(id);
    }

    @PostMapping("/questions/answer/{questionId}")
    public Map<String, String> checkAnswer(@PathVariable int questionId, @RequestBody Map<String, String> answer) {
        return quizAppService.submitAnswer(questionId, answer.get("answer"));
    }

    @GetMapping("/load/question/test")
    @Profile("!production")
    public boolean autoLoadQuestions() {
        return true;
    }
}
