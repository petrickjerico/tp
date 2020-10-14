package seedu.address.model;

import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;

public interface QuizModel {
    // QUIZ
    Question start(Quiz quiz);

    boolean hasStarted();

    void tallyScore(boolean isCorrect);

    Question getQuestion();

    Answer getAnswer();

    double stopQuiz();

    String getQuizRecords(int index);
}
