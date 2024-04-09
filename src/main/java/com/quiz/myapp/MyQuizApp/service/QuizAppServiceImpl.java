package com.quiz.myapp.MyQuizApp.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;
import com.quiz.myapp.MyQuizApp.repository.QuizAppRepoImpl;
import com.quiz.myapp.MyQuizApp.util.QuizQuestionTranslatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class QuizAppServiceImpl implements QuizAppService {
    private final QuizAppRepoImpl mQuizAppRepoImpl;

    @Autowired
    public QuizAppServiceImpl(QuizAppRepoImpl quizAppRepoImpl) {
        mQuizAppRepoImpl = quizAppRepoImpl;
    }

    @Override
    public List<QuizQuestionWrapper> getQuizQuestions() {
        return QuizQuestionTranslatorUtil.getTranslatedList(mQuizAppRepoImpl.getQuizQuestions());
    }

    @Override
    public void putDefaultEntries() {
        if (mQuizAppRepoImpl.getQuizQuestions().isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                File resource = new ClassPathResource("input_questions.json").getFile();

                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

                QuizQuestion[] questions = mapper.readValue(resource, QuizQuestion[].class);

                for (QuizQuestion question : questions) {
                    mQuizAppRepoImpl.save(question);
                }

                List<QuizQuestion> newQuestions = mQuizAppRepoImpl.getQuizQuestions();

                System.out.println("New DB data: " + newQuestions.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public QuizQuestion nextQuestion() {
        return mQuizAppRepoImpl.getNextQuestion();
    }
}
