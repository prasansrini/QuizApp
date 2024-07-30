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
import java.util.*;

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
            System.out.println("Working Directory = " + System.getProperty("user.dir"));

            for (QuizQuestion question : populateQuestions()) {
                mQuizAppRepoImpl.save(question);
            }

            List<QuizQuestion> newQuestions = mQuizAppRepoImpl.getQuizQuestions();

            System.out.println("New DB data: " + newQuestions.size());
        }
    }

    private QuizQuestion[] populateQuestions() {
        QuizQuestion[] quizQuestions = new QuizQuestion[10];
        
        quizQuestions[0] = new QuizQuestion("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, "Paris", false);
        quizQuestions[1] = new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, "Mars", false);
        quizQuestions[2] = new QuizQuestion("What is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, "Pacific", false);
        quizQuestions[3] = new QuizQuestion("Who wrote 'Romeo and Juliet'?", new String[]{"William Shakespeare", "Charles Dickens", "Mark Twain", "Ernest Hemingway"}, "William Shakespeare", false);
        quizQuestions[4] = new QuizQuestion("What is the chemical symbol for water?", new String[]{"H2O", "CO2", "NaCl", "O2"}, "H2O", false);
        quizQuestions[5] = new QuizQuestion("How many continents are there on Earth?", new String[]{"5", "6", "7", "8"}, "7", false);
        quizQuestions[6] = new QuizQuestion("What is the tallest mountain in the world?", new String[]{"K2", "Kangchenjunga", "Lhotse", "Mount Everest"}, "Mount Everest", false);
        quizQuestions[7] = new QuizQuestion("Who painted the Mona Lisa?", new String[]{"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"}, "Leonardo da Vinci", false);
        quizQuestions[8] = new QuizQuestion("What is the hardest natural substance on Earth?", new String[]{"Gold", "Iron", "Diamond", "Platinum"}, "Diamond", false);
        quizQuestions[9] = new QuizQuestion("Which element has the chemical symbol 'O'?", new String[]{"Oxygen", "Gold", "Silver", "Iron"}, "Oxygen", false);

        return quizQuestions;
    }

    @Override
    public QuizQuestionWrapper nextQuestion() {
        return mQuizAppRepoImpl.getNextQuestion();
    }

    @Override
    public QuizQuestionWrapper getLifeLine(int questionId) {
        QuizQuestion question = mQuizAppRepoImpl.findQuizQuestion(questionId);

        Optional<String> notAnswer = Arrays.stream(question.getOptions())
                .filter(option -> !option.equals(question.getAnswer()))
                .findFirst();

        notAnswer.ifPresent(s -> question.setOptions(new String[]{s, question.getAnswer()}));

        return QuizQuestionTranslatorUtil.getTranslated(question);
    }

    @Override
    public Map<String, String> submitAnswer(int questionId, String answer) {
        QuizQuestion question = mQuizAppRepoImpl.findQuizQuestion(questionId);
        Map<String, String> result = new HashMap<>();

        if (question.getAnswer().equals(answer)) {
            result.put("result", "correct");
        } else {
            result.put("result", "wrong");
        }

        return result;
    }
}
