package com.quiz.myapp.MyQuizApp.service;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;

import java.util.List;
import java.util.Map;

public interface QuizAppService {
    List<QuizQuestionWrapper> getQuizQuestions();
    void putDefaultEntries();
    QuizQuestionWrapper nextQuestion();
    QuizQuestionWrapper getLifeLine(int questionId);
    Map<String, String> submitAnswer(int questionId, String answer);
}
