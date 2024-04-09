package com.quiz.myapp.MyQuizApp.repository;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuizAppRepoImpl implements QuizAppDAO {

    private final EntityManager mEntityManager;

    @Autowired
    public QuizAppRepoImpl(EntityManager entityManager) {
        mEntityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(QuizQuestion question) {
        mEntityManager.persist(question);
    }

    @Override
    public List<QuizQuestion> getQuizQuestions() {
        TypedQuery<QuizQuestion> query = mEntityManager.createQuery("FROM QuizQuestion", QuizQuestion.class);

        return query.getResultList();
    }

    @Override
    public QuizQuestion getNextQuestion() {
//        TypedQuery<QuizQuestion> query = mEntityManager

        return new QuizQuestion();
    }
}
