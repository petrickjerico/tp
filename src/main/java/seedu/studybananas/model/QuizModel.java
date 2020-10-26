package seedu.studybananas.model;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;

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

    Quiz getQuizRecordsToView();

    void setQuizRecordsToView(FlashcardSetName name);

    void deleteQuiz(FlashcardSetName name);

    ReadOnlyQuizRecords getAllQuizRecords();

    void saveAnswer(String answer);
}
