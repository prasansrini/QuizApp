package com.quiz.myapp.MyQuizApp.repository;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;

import java.util.List;

public interface QuizAppDAO {
    void save(QuizQuestion question);

    List<QuizQuestion> getQuizQuestions();

    QuizQuestion getNextQuestion();
}
