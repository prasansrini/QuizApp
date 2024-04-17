package com.quiz.myapp.MyQuizApp.util

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.function.Consumer

internal class QuizQuestionTranslatorUtilTest {

    @Test
    fun translatedTest() {
        val question = QuizQuestion(
            "Question 1", arrayOf("option1", "option2", "option3", "option4"),
            "answer", true
        )

        assertQuizQuestion(question)
    }

    @Test
    fun translatedListTest() {
        val questions = loadQuizQuestions()

        questions.forEach(Consumer { question: QuizQuestion -> this.assertQuizQuestion(question) })
    }

    private fun assertQuizQuestion(question: QuizQuestion) {
        val wrapper = QuizQuestionTranslatorUtil.getTranslated(question)

        println(wrapper)

        Assertions.assertEquals(question.question, wrapper.question)
        Assertions.assertEquals(question.options, wrapper.options)
    }

    private fun loadQuizQuestions(): List<QuizQuestion> {
        val questions: MutableList<QuizQuestion> = ArrayList()
        for (i in 0..9) {
            val question = QuizQuestion(
                "Question $i",
                arrayOf("option 1", "option 2", "option 3", "option 4"), "answer $i", true
            )
            questions.add(question)
        }

        return questions
    }
}