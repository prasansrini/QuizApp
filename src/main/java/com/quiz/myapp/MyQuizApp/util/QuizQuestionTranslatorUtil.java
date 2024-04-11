package com.quiz.myapp.MyQuizApp.util;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;

import java.util.List;

public class QuizQuestionTranslatorUtil {

    private QuizQuestionTranslatorUtil() {
    }

    public static QuizQuestionWrapper getTranslated(QuizQuestion question) {
        return new QuizQuestionWrapper(question.getId(), question.getQuestion(), question.getOptions());
    }

    public static List<QuizQuestionWrapper> getTranslatedList(List<QuizQuestion> questions) {
        return questions.stream()
                .map(quizQuestion -> new QuizQuestionWrapper(quizQuestion.getId(), quizQuestion.getQuestion(),
                        quizQuestion.getOptions()))
                .toList();
    }
}
