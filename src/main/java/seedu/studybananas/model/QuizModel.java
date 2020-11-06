package seedu.studybananas.model;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;

public interface QuizModel {

    /**
     * Starts a {@code Quiz} by getting the first question.
     * @param quiz specified to start
     * @return the first {@code Question} within the quiz
     */
    Question start(Quiz quiz);

    /**
     * Checks if a {@code Quiz} has already started.
     * @return a boolean
     */
    boolean hasStarted();

    /**
     * Tallies the score based on whether the user answer is correct.
     * @param isCorrect whether the user answered the {@code Question} correctly.
     */
    void tallyScore(boolean isCorrect);

    /**
     * Obtains the current {@code Quiz} in action.
     * @return the current quiz
     */
    Quiz getQuiz();

    /**
     * Obtains the next {@code Question} in the {@code Quiz}.
     * @return the next question in line
     */
    Question getQuestion();

    /**
     * Obtains the correct answer to the current {@code Quiz}.
     * @return the current question
     */
    Answer getAnswer();

    /**
     * Stops the current {@code Quiz}.
     * @return a string of quiz score
     */
    String stopQuiz();

    /**
     * Cancels the {@code Quiz}.
     */
    void cancelQuiz();

    /**
     * Obtains the quiz records of a {@code Quiz}.
     * @param name of the flashcard set associated with the quiz
     * @return a string of quiz score
     */
    String getQuizRecords(FlashcardSetName name);

    /**
     * Obtains the {@code Quiz} to view its score.
     * @return the specified quiz
     */
    Quiz getQuizRecordsToView();

    /**
     * Sets the {@code FlashcardSetName} of the {@code Quiz} scores.
     * @param name of a flashcard set
     */
    void setQuizRecordsToView(FlashcardSetName name);

    /**
     * Deletes the quiz with the given {@code FlashcardSetName}.
     * @param name of flashcard set as specified
     */
    void deleteQuiz(FlashcardSetName name);

    /**
     * Gets the {@code ReadOnlyQuizRecords}.
     * @return the quiz records
     */
    ReadOnlyQuizRecords getAllQuizRecords();

    /**
     * Saves the user answer to the current question.
     * @param answer provided by the user
     */
    void saveAnswer(String answer);
}
