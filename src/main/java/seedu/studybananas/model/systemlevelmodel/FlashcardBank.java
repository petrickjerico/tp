package seedu.studybananas.model.systemlevelmodel;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.UniqueFlashcardSetList;



/**
 * Wraps all data of flashcard sets.
 * Duplicates are not allowed.
 */
public class FlashcardBank implements ReadOnlyFlashcardBank {

    private final UniqueFlashcardSetList flashcardSets;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        flashcardSets = new UniqueFlashcardSetList();
    }

    public FlashcardBank() {}

    /**
     * Creates a FlashcardBank using the FlashcardSets in the {@code toBeCopied}
     */
    public FlashcardBank(ReadOnlyFlashcardBank toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Replaces the contents of the task list with {@code flashcardSets}.
     * {@code flashcardSets} must not contain duplicate flashcardSets.
     */
    public void setFlashcardSets(List<FlashcardSet> flashcardSets) {
        this.flashcardSets.setFlashcardSets(flashcardSets);
    }

    /**
     * Resets the existing data of this {@code FlashcardBank} with {@code newData}.
     */
    public void resetData(ReadOnlyFlashcardBank newData) {
        requireNonNull(newData);

        setFlashcardSets(newData.getFlashcardSetList());
    }

    //// task-level operations

    /**
     * Returns true if a task with the same identity as {@code task} exists in the schedule.
     */
    public boolean hasFlashcardSet(FlashcardSet task) {
        requireNonNull(task);
        return flashcardSets.contains(task);
    }

    /**
     * Adds a task to the schedule.
     * The task must not already exist in the schedule.
     */
    public void addFlashcardSet(FlashcardSet t) {
        flashcardSets.add(t);
    }

    /**
     * Replaces the given task {@code target} in the list with {@code editedFlashcardSet}.
     * {@code target} must exist in the schedule.
     * The task identity of {@code editedFlashcardSet} must not be the same as another existing task in the schedule.
     */
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        requireNonNull(editedFlashcardSet);

        flashcardSets.setFlashcardSet(target, editedFlashcardSet);
    }

    /**
     * Removes {@code key} from this {@code FlashcardBank}.
     * {@code key} must exist in the FlashcardBank.
     */
    public void removeFlashcardSet(FlashcardSet key) {
        flashcardSets.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return flashcardSets.asUnmodifiableObservableList().size() + " sets";
    }

    @Override
    public ObservableList<FlashcardSet> getFlashcardSetList() {
        return flashcardSets.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FlashcardBank // instanceof handles nulls
                && flashcardSets.equals(((FlashcardBank) other).flashcardSets));
    }

    @Override
    public int hashCode() {
        return flashcardSets.hashCode();
    }
}
