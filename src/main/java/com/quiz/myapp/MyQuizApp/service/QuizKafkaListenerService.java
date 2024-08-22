package com.quiz.myapp.MyQuizApp.service;

public interface QuizKafkaListenerService {
    void consumeMessage(String message);
}
