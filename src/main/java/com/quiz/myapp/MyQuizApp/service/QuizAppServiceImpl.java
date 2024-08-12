package com.quiz.myapp.MyQuizApp.service;

import com.quiz.myapp.MyQuizApp.entity.QuizQuestion;
import com.quiz.myapp.MyQuizApp.model.QuizQuestionWrapper;
import com.quiz.myapp.MyQuizApp.repository.QuizAppRepoImpl;
import com.quiz.myapp.MyQuizApp.util.QuizQuestionTranslatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private List<QuizQuestion> populateQuestions() {
        return Arrays.asList(
                new QuizQuestion(
                        "What is the capital of Japan?",
                        new String[]{"Seoul", "Bangkok", "Tokyo", "Beijing"},
                        "Tokyo",
                        true
                ),
                new QuizQuestion(
                        "How many elements are there in the periodic table as of 2023?",
                        new String[]{"112", "118", "120", "125"},
                        "118",
                        true
                ),
                new QuizQuestion(
                        "What is the chemical symbol for gold?",
                        new String[]{"Au", "Ag", "Gd", "Ga"},
                        "Au",
                        true
                ),
                new QuizQuestion(
                        "What force keeps the planets in orbit around the sun?",
                        new String[]{"Electromagnetic force", "Gravitational force", "Centrifugal force", "Nuclear " +
                                "force"},
                        "Gravitational force",
                        true
                ),
                new QuizQuestion(
                        "What is the longest river in the world?",
                        new String[]{"Amazon", "Nile", "Yangtze", "Mississippi"},
                        "Nile",
                        true
                ),
                new QuizQuestion(
                        "Mount Everest is located in which country?",
                        new String[]{"India", "Nepal", "Tibet", "China"},
                        "Nepal",
                        true
                ),
                new QuizQuestion(
                        "Who was the first President of the United States?",
                        new String[]{"Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"},
                        "George Washington",
                        true
                ),
                new QuizQuestion(
                        "In what year did the Titanic sink?",
                        new String[]{"1912", "1905", "1898", "1923"},
                        "1912",
                        true
                ),
                new QuizQuestion(
                        "Who wrote 'To Kill a Mockingbird'?",
                        new String[]{"Harper Lee", "Ernest Hemingway", "J.D. Salinger", "Mark Twain"},
                        "Harper Lee",
                        true
                ),
                new QuizQuestion(
                        "The Mona Lisa was painted by which artist?",
                        new String[]{"Vincent Van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo"},
                        "Leonardo da Vinci",
                        true
                ),
                new QuizQuestion(
                        "In what year were the first modern Olympics held?",
                        new String[]{"1896", "1900", "1904", "1892"},
                        "1896",
                        true
                ),
                new QuizQuestion(
                        "Which country won the 2018 FIFA World Cup?",
                        new String[]{"France", "Brazil", "Germany", "Argentina"},
                        "France",
                        true
                ),
                new QuizQuestion(
                        "Who played the character of Harry Potter in the movie series?",
                        new String[]{"Daniel Radcliffe", "Rupert Grint", "Tom Felton", "Elijah Wood"},
                        "Daniel Radcliffe",
                        true
                ),
                new QuizQuestion(
                        "What is the highest-grossing film of all time (as of 2023)?",
                        new String[]{"Avatar", "Avengers: Endgame", "Titanic", "Star Wars: The Force Awakens"},
                        "Avatar",
                        true
                ),
                new QuizQuestion(
                        "What does 'HTTP' stand for?",
                        new String[]{"HyperText Transfer Protocol", "HighText Transfer Protocol", "HyperText " +
                                "Transmission Protocol", "HyperText Transfer Process"},
                        "HyperText Transfer Protocol",
                        true
                ),
                new QuizQuestion(
                        "Who is known as the father of the computer?",
                        new String[]{"Charles Babbage", "Alan Turing", "John Atanasoff", "Bill Gates"},
                        "Charles Babbage",
                        true
                ),
                new QuizQuestion(
                        "Which country is traditionally believed to be the birthplace of pizza?",
                        new String[]{"Italy", "France", "Spain", "Greece"},
                        "Italy",
                        true
                ),
                new QuizQuestion(
                        "What is the main ingredient in traditional Japanese miso soup?",
                        new String[]{"Rice", "Noodles", "Tofu", "Miso paste"},
                        "Miso paste",
                        true
                ),
                new QuizQuestion(
                        "Which planet is known as the Red Planet?",
                        new String[]{"Mars", "Jupiter", "Saturn", "Venus"},
                        "Mars",
                        true
                ),
                new QuizQuestion(
                        "What is the hardest natural substance on Earth?",
                        new String[]{"Gold", "Iron", "Diamond", "Quartz"},
                        "Diamond",
                        true
                ),
                new QuizQuestion(
                        "Who invented the lightbulb?",
                        new String[]{"Thomas Edison", "Nikola Tesla", "Alexander Graham Bell", "Benjamin Franklin"},
                        "Thomas Edison",
                        true
                ),
                new QuizQuestion(
                        "What is the largest ocean on Earth?",
                        new String[]{"Atlantic", "Indian", "Southern", "Pacific"},
                        "Pacific",
                        true
                ),
                new QuizQuestion(
                        "What year did the Berlin Wall fall?",
                        new String[]{"1989", "1991", "1987", "1990"},
                        "1989",
                        true
                ),
                new QuizQuestion(
                        "What is the capital city of Australia?",
                        new String[]{"Sydney", "Melbourne", "Canberra", "Perth"},
                        "Canberra",
                        true
                ),
                new QuizQuestion(
                        "Who is considered the father of modern physics?",
                        new String[]{"Isaac Newton", "Galileo Galilei", "Albert Einstein", "Niels Bohr"},
                        "Albert Einstein",
                        true
                ),
                new QuizQuestion(
                        "What is the smallest country in the world?",
                        new String[]{"Vatican City", "Monaco", "Nauru", "Liechtenstein"},
                        "Vatican City",
                        true
                ),
                new QuizQuestion(
                        "Who wrote the national anthem of the United States of America?",
                        new String[]{"Francis Scott Key", "John Stafford Smith", "George Washington", "Thomas " +
                                "Jefferson"},
                        "Francis Scott Key",
                        true
                ),
                new QuizQuestion(
                        "What is the longest-running Broadway show?",
                        new String[]{"The Phantom of the Opera", "Les Misérables", "Cats", "Chicago"},
                        "The Phantom of the Opera",
                        true
                ),
                new QuizQuestion(
                        "What is the currency of Japan?",
                        new String[]{"Yuan", "Won", "Yen", "Dollar"},
                        "Yen",
                        true
                ),
                new QuizQuestion(
                        "Who discovered penicillin?",
                        new String[]{"Marie Curie", "Alexander Fleming", "Louis Pasteur", "Joseph Lister"},
                        "Alexander Fleming",
                        true
                ),
                new QuizQuestion(
                        "What is the largest desert in the world?",
                        new String[]{"Sahara", "Arabian", "Gobi", "Antarctic"},
                        "Antarctic",
                        true
                ),
                new QuizQuestion(
                        "Who painted the ceiling of the Sistine Chapel?",
                        new String[]{"Leonardo da Vinci", "Donatello", "Michelangelo", "Raphael"},
                        "Michelangelo",
                        true
                ),
                new QuizQuestion(
                        "What element does 'O' represent on the periodic table?",
                        new String[]{"Gold", "Oxygen", "Osmium", "Olive"},
                        "Oxygen",
                        true
                )
        );
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
