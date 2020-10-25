package seedu.studybananas.model.systemlevelmodel;

import static java.util.Objects.requireNonNull;

import java.util.Map;

import javafx.collections.ObservableMap;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.quiz.UniqueQuizRecordsMap;

public class QuizRecords implements ReadOnlyQuizRecords {

    private final UniqueQuizRecordsMap quizRecordsMap;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        quizRecordsMap = new UniqueQuizRecordsMap();
    }

    public QuizRecords() {}

    /**
     * Creates Quiz Records using the Quiz Records in the {@code toBeCopied}
     */
    public QuizRecords(ReadOnlyQuizRecords toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Replaces the contents of the quiz records list with {@code }.
     * {@code quizRecords} must not contain duplicate quizRecords.
     */
    public void setQuizRecordsMap(Map<FlashcardSetName, Quiz> quizRecordsMap) {
        this.quizRecordsMap.setQuizRecords(quizRecordsMap);
    }

    /**
     * Resets the existing data of this {@code QuizRecords} with {@code newData}.
     */
    public void resetData(ReadOnlyQuizRecords newData) {
        requireNonNull(newData);

        setQuizRecordsMap(newData.getQuizRecordsMap());
    }

    //// task-level operations

    /**
     * Returns true if a quiz record with the same identity as {@code quiz record} exists in the quiz records.
     */
    public boolean hasQuizRecord(Quiz quiz) {
        requireNonNull(quiz);
        return quizRecordsMap.contains(quiz);
    }

    /**
     * Adds a quiz record to the map.
     * The quiz must not already exist in the map.
     */
    public void addQuiz(Quiz quiz) {
        quizRecordsMap.add(quiz.getFlsetName(), quiz);
    }

    /**
     * Replaces the given quiz {@code target} in the list with {@code editedQuiz}.
     * {@code target} must exist in the schedule.
     * The quiz identity of {@code editedQuiz} must not be the same as another existing quiz in the quiz records.
     */
    public void setQuiz(Quiz target, Quiz editedQuiz) {
        requireNonNull(editedQuiz);

        quizRecordsMap.setQuiz(target, editedQuiz);
    }

    /**
     * Removes {@code key} from this {@code QuizRecords}.
     * {@code key} must exist in the QuizRecords.
     */
    public void removeQuiz(FlashcardSetName key) {
        quizRecordsMap.remove(key);
    }

    public Quiz getQuiz(FlashcardSetName name) {
        return quizRecordsMap.getQuiz(name);
    }

    //// util methods

    @Override
    public String toString() {
        return quizRecordsMap.asUnmodifiableObservableMap().toString();
    }

    @Override
    public ObservableMap<FlashcardSetName, Quiz> getQuizRecordsMap() {
        return quizRecordsMap.asUnmodifiableObservableMap();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof QuizRecords // instanceof handles nulls
                && quizRecordsMap.equals(((QuizRecords) other).getQuizRecordsMap()));
    }

    @Override
    public int hashCode() {
        return quizRecordsMap.hashCode();
    }
}
