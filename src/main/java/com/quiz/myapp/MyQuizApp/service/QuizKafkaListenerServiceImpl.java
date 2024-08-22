package com.quiz.myapp.MyQuizApp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class QuizKafkaListenerServiceImpl implements QuizKafkaListenerService {
    @KafkaListener(topics = "my-first-topic")
    @Override
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
    }
}
