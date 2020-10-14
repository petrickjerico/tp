package seedu.address.model.systemlevelmodel;

import javafx.collections.ObservableList;
import seedu.address.model.flashcard.FlashcardSet;

/**
 * Unmodifiable view of a flashcard bank.
 */
public interface ReadOnlyFlashcardBank {

    /**
     * Returns an unmodifiable view of the list of flashcard sets.
     * This list will not contain any duplicate flashcard sets.
     */
    ObservableList<FlashcardSet> getFlashcardSetList();
}
