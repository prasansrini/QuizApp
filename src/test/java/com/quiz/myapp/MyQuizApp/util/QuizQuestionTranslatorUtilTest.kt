package com.quiz.myapp.MyQuizApp.util;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizQuestionTranslatorUtilTest {

    @Test
    void getTranslated() {

        QuizQuestion question = new QuizQuestion("Question 1", new String[]{"option1", "option2", "option3", "option4"},
                "answer", true);

        assertQuizQuestion(question);
    }

    @Test
    void getTranslatedList() {
        List<QuizQuestion> questions = loadQuizQuestions();

        questions.forEach(this::assertQuizQuestion);
    }

    private void assertQuizQuestion(QuizQuestion question) {
        QuizQuestionWrapper wrapper = QuizQuestionTranslatorUtil.getTranslated(question);

        System.out.println(wrapper);

        assertEquals(question.getQuestion(), wrapper.getQuestion());
        assertEquals(question.getOptions(), wrapper.getOptions());
    }

    private List<QuizQuestion> loadQuizQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            QuizQuestion question = new QuizQuestion("Question " + i,
                    new String[]{"option 1", "option 2", "option 3", "option 4"}, "answer " + i, true);
            questions.add(question);
        }

        return questions;
    }
}