package seedu.studybananas.model.quiz;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.quiz.exceptions.QuizNotFoundException;

public class UniqueQuizRecordsMap {

    private final ObservableMap<FlashcardSetName, Quiz> internalMap = FXCollections.observableHashMap();
    private final ObservableMap<FlashcardSetName, Quiz> internalUnmodifiableMap =
            FXCollections.unmodifiableObservableMap(internalMap);

    /**
     * Returns true if the hash map contains an equivalent quiz as the given argument.
     */
    public boolean contains(Quiz toCheck) {
        requireNonNull(toCheck);
        return internalMap.containsValue(toCheck);
    }

    /**
     * Adds a Quiz to the hashmap with the corresponding flashcard set name..
     */
    public void add(FlashcardSetName flashcardSetName, Quiz toAdd) {
        requireNonNull(toAdd);

        internalMap.put(flashcardSetName, toAdd);
    }

    /**
     * Replaces the quiz {@code target} in the list with {@code editedQuiz}.
     * {@code target} must exist in the list.
     * The editedQuiz of {@code editedQuiz} must not be the same as another
     * existing quiz in the list.
     */
    public void setQuiz(Quiz target, Quiz editedQuiz) {
        requireAllNonNull(target, editedQuiz);

        if (!contains(target)) {
            throw new QuizNotFoundException();
        }

        if (!target.equals(editedQuiz) && contains(editedQuiz)) {
            throw new QuizNotFoundException();
        }

        internalMap.remove(target.getFlsetName());
        internalMap.put(editedQuiz.getFlsetName(), editedQuiz);
    }

    /**
     * Removes the equivalent quiz from the list.
     * The quiz must exist in the list.
     */
    public void remove(FlashcardSetName toRemove) {
        requireNonNull(toRemove);
        if (!internalMap.containsKey(toRemove)) {
            throw new QuizNotFoundException();
        }
        internalMap.remove(toRemove);
    }

    public Quiz getQuiz(FlashcardSetName name) {
        return internalMap.get(name);
    }

    public void setQuizRecords(UniqueQuizRecordsMap replacement) {
        requireNonNull(replacement);
        internalMap.putAll(replacement.internalMap);
    }

    /**
     * Replaces the contents of this list with {@code quizRecords}.
     * {@code quizRecords} must not contain duplicate quizzes.
     */
    public void setQuizRecords(Map<FlashcardSetName, Quiz> quizRecords) {
        requireAllNonNull(quizRecords);
        internalMap.putAll(quizRecords);
    }

    /**
     * Returns the backing map as an unmodifiable {@code ObservableList}.
     */
    public ObservableMap<FlashcardSetName, Quiz> asUnmodifiableObservableMap() {
        return internalUnmodifiableMap;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueQuizRecordsMap // instanceof handles nulls
                && internalMap.equals(((UniqueQuizRecordsMap) other).internalMap));
    }

    @Override
    public int hashCode() {
        return internalMap.hashCode();
    }
}
