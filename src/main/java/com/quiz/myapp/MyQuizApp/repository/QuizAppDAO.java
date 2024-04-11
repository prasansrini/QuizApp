package com.quiz.myapp.MyQuizApp.repository;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;

import java.util.List;

public interface QuizAppDAO {
    void save(QuizQuestion question);

    List<QuizQuestion> getQuizQuestions();

    QuizQuestionWrapper getNextQuestion();

    QuizQuestion findQuizQuestion(int questionId);
}
