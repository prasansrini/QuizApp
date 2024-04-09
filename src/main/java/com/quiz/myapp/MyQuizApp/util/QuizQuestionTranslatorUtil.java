package com.quiz.myapp.MyQuizApp.util;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestionTranslatorUtil {

    private QuizQuestionTranslatorUtil() {
    }

    public static QuizQuestionWrapper getTranslated(QuizQuestion question) {
        return new QuizQuestionWrapper(question.getId(), question.getQuestion(), question.getOptions());
    }

    public static List<QuizQuestionWrapper> getTranslatedList(List<QuizQuestion> questions) {
        List<QuizQuestionWrapper> responseQuestions = new ArrayList<>();

        for (QuizQuestion question : questions) {
            QuizQuestionWrapper wrapper = new QuizQuestionWrapper(question.getId(), question.getQuestion(),
                    question.getOptions());
            responseQuestions.add(wrapper);
        }

        return responseQuestions;
    }
}
