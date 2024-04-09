package com.quiz.myapp.MyQuizApp.service;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;

import java.util.List;

public interface QuizAppService {
    List<QuizQuestionWrapper> getQuizQuestions();
    void putDefaultEntries();
    QuizQuestion nextQuestion();
}
