package com.quiz.myapp.MyQuizApp.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "quiz")
@EntityListeners(QuizQuestion.class)
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "question")
    private String question;

    @Column(name = "options")
    private String[] options;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_shown", columnDefinition = "boolean default false")
    private boolean isShown;

    public QuizQuestion() {
    }

    public QuizQuestion(String question, String[] options, String answer, boolean isShown) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.isShown = isShown;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer='" + answer + '\'' +
                ", isShown=" + isShown +
                '}';
    }
}
