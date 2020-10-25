package seedu.studybananas.model.flashcard;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.studybananas.model.flashcard.exceptions.DuplicateFlashcardSetException;
import seedu.studybananas.model.flashcard.exceptions.FlashcardSetNotFoundException;

public class UniqueFlashcardSetList implements Iterable<FlashcardSet> {

    private final ObservableList<FlashcardSet> internalList = FXCollections.observableArrayList();
    private final ObservableList<FlashcardSet> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent flashcard set as the given argument.
     */
    public boolean contains(FlashcardSet toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    /**
     * Adds a flashcard set to the list.
     * The flashcard set  must not already exist in the list.
     */
    public void add(FlashcardSet toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateFlashcardSetException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the flashcard set {@code target} in the list with {@code edittedFlashcardSet}.
     * {@code target} must exist in the list.
     * The edittedFlashcardSet of {@code edittedFlashcardSet} must not be the same as another
     * existing flashcard set in the list.
     */
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        requireAllNonNull(target, editedFlashcardSet);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new FlashcardSetNotFoundException();
        }

        if (!target.equals(editedFlashcardSet) && contains(editedFlashcardSet)) {
            throw new DuplicateFlashcardSetException();
        }

        internalList.set(index, editedFlashcardSet);
    }

    /**
     * Removes the equivalent task from the list.
     * The task must exist in the list.
     */
    public void remove(FlashcardSet toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new FlashcardSetNotFoundException();
        }
    }

    public void setFlashcardSets(UniqueFlashcardSetList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code flashcardSets}.
     * {@code flashcardSets} must not contain duplicate flashcardSets.
     */
    public void setFlashcardSets(List<FlashcardSet> flashcardSets) {
        requireAllNonNull(flashcardSets);
        if (!flashcardSetsAreUnique(flashcardSets)) {
            throw new DuplicateFlashcardSetException();
        }

        internalList.setAll(flashcardSets);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<FlashcardSet> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<FlashcardSet> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueFlashcardSetList // instanceof handles nulls
                && internalList.equals(((UniqueFlashcardSetList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code flashcardSets} contains only unique flashcardSets.
     */
    private boolean flashcardSetsAreUnique(List<FlashcardSet> flashcardSets) {
        for (int i = 0; i < flashcardSets.size() - 1; i++) {
            for (int j = i + 1; j < flashcardSets.size(); j++) {
                if (flashcardSets.get(i).equals(flashcardSets.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
