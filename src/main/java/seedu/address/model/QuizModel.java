package seedu.address.model;

import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.FlashcardSetName;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;

public interface QuizModel {
    // QUIZ
    Question start(Quiz quiz);

    boolean hasStarted();

    void tallyScore(boolean isCorrect);

    Question getQuestion();

    Answer getAnswer();

    String stopQuiz();

    void cancelQuiz();

    String getQuizRecords(FlashcardSetName name);

    void deleteQuiz(FlashcardSetName name);

    ReadOnlyQuizRecords getAllQuizRecords();

    void saveAnswer(String answer);
}
