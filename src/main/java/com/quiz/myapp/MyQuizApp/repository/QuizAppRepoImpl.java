package com.quiz.myapp.MyQuizApp.repository;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;
import com.quiz.myapp.MyQuizApp.util.QuizQuestionTranslatorUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public QuizQuestionWrapper getNextQuestion() {
        TypedQuery<QuizQuestion> query = mEntityManager.createQuery("FROM QuizQuestion", QuizQuestion.class);
        List<QuizQuestion> questions = query.getResultList();
        Optional<QuizQuestion> question = questions.stream().filter(quizQuestion -> !quizQuestion.isShown()).findFirst();

        QuizQuestionWrapper wrapper = QuizQuestionTranslatorUtil.getTranslated(question.get());
        question.get().setShown(true);

        mEntityManager.merge(question.get());

        return wrapper;
    }

    @Override
    public QuizQuestion findQuizQuestion(int questionId) {
        return mEntityManager.find(QuizQuestion.class, questionId);
    }
}
